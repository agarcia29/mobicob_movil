package com.mobicob.mobile.app.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.ui.adapter.ClientAdapter;
import com.mobicob.mobile.app.session.Preferences;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.apiclient.JsonKeys;
import com.mobicob.mobile.app.apiclient.network.RetrofitInstance;
import com.mobicob.mobile.app.apiclient.services.MobicobApiServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssignmentsActivity extends Activity implements View.OnClickListener{
    private RecyclerView mRecyclerView;
    private ClientAdapter mAdapter;

    private TextView txtClientDeadLine;


    private static final String KEY_EXTRA_NUMBER_CAMPAIGN = JsonKeys.TASK_CAMPAIGN_NUMBER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

       // LinearLayout editGestionButton = (LinearLayout) findViewById(R.id.editGestionButton);
       // editGestionButton.setOnClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssignments);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new ClientAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

       try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_client);

            RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssignments);
            mRecyclerView.setHasFixedSize(true);

            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new ClientAdapter(this);
            mRecyclerView.setAdapter(mAdapter);

            //  Gson gsonTasks = RetrofitInstance.buildTasksGson();
            MobicobApiServices api = RetrofitInstance.getApiServicesTask(AssignmentsActivity.this);
            Call<TasksResponse> call = api.tasks(Preferences.getToken(AssignmentsActivity.this));
            call.enqueue(new Callback<TasksResponse>() {
                @Override
                public void onResponse(Call<TasksResponse> call, Response<TasksResponse> response) {
                    if (response.isSuccessful()) {
                        TasksResponse tasklist = response.body();
                        mAdapter.setDataSet(tasklist);
                    }
                }

                @Override
                public void onFailure(Call<TasksResponse> call, Throwable t) {
                    Log.e("MOBICOB", t.getMessage(), t);
                    Toast.makeText(AssignmentsActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch(Exception e)
        {
            Log.e("MOBICOB", e.getMessage(), e);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class );
        startActivity(intent);
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
}

     /*   Bundle extra = getIntent().getExtras();
        int numberCampaign = extra.getInt(KEY_EXTRA_NUMBER_CAMPAIGN);

        CardView cardView = (CardView) findViewById(R.id.cardViewTask);
        TextView txtNumberCampaign = (TextView) findViewById(R.id.tvClientNoCampaign);
        txtNumberCampaign.setText(String.valueOf(numberCampaign));*/