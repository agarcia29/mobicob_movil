package com.mobicob.mobile.app.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.apiclient.network.RetrofitInstance;
import com.mobicob.mobile.app.apiclient.services.MobicobApiServices;
import com.mobicob.mobile.app.db.entity.User;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.session.Preferences;
import com.mobicob.mobile.app.wrapper.LoginRequestWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity {

    private View mProgressView;
    private View mResultFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button mSaveButton = (Button) findViewById(R.id.saveButton);


        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isOnline()) {
                   /*TODO:Guardar en la base de datos temporal*/
                    return;
                }
                attemptSendResult();

            }
        });
        Button mEmailSignInButton = (Button) findViewById(R.id.saveButton);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSendResult();
            }
        });

        mResultFormView = findViewById(R.id.result_form);
        mProgressView = findViewById(R.id.result_progress);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_logOut:
                //metodoAdd()
                Preferences.get(this).sessionDestroy();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
    private void showLoginError(String error) {
        Toast.makeText(ResultActivity.this, error, Toast.LENGTH_LONG).show();
    }
    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    private void showSaveWithoutConection(String message) {
        /*TODO: MENSAJE DE GUARDADO EN BASE DE DATOS LOCAL
        //Toast.makeText(LoginActivity.this, error, Toast.LENGTH_LONG).show();
         */
    }

    private void attemptSendResult() {


        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            //Gson gsonLogin = RetrofitInstance.buildLoginGson();
            MobicobApiServices api = RetrofitInstance.getApiServicesLogin();
            Call<LoginResponse> loginCall = api.login(new LoginRequestWrapper(email, password));
            loginCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                    showProgress(false);

                    if (response.isSuccessful()) {
                        Preferences.get(LoginActivity.this).saveAuthData(response.body());
                        User currentUser =new User();
                        currentUser.setEmail(response.body().getEmail());
                        currentUser.setId(response.body().getId());
                        mUserViewModel.insert(currentUser);
                        showMainScreen();
                    }else{
                        String error;
                        if (response.errorBody()
                                .contentType()
                                .subtype()
                                .equals("application/json")) {

                            error = response.message();
                            Log.d("LoginActivity", error);
                        } else {
                            error = response.message();
                            showLoginError(error);
                            return;
                        }
                    }
                }

                @Override
                public void onFailure (Call<LoginResponse> call, Throwable t) {
                    Log.e("MOBICOB", t.getMessage(), t);
                    showProgress(false);
                    showLoginError(t.getMessage());
                }

            });
        }

        /**
         * Represents an asynchronous login/registration task used to authenticate
         * the user.
         */
        class UserLoginTask extends AsyncTask<Void, Void, Integer> {

            private final String mEmail;
            private final String mPassword;

            UserLoginTask(String email, String password) {
                mEmail = email;
                mPassword = password;
            }



            @Override
            protected void onPostExecute(final Integer success) {
                showProgress(false);

                switch (success) {
                    case 1:
                        showMainScreen();
                        break;
                    case 2:
                    case 3:
                        showLoginError("Número de identificación o contraseña inválidos");
                        break;
                    case 4:
                        showLoginError(getString(R.string.error_server));
                        break;
                }
            }

            @Override
            protected void onCancelled() {
                showProgress(false);
            }

        }
    }

    private void showMainScreen() {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mResultFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mResultFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mResultFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mResultFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
    
}
