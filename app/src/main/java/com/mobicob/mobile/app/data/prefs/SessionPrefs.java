package com.mobicob.mobile.app.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.mobicob.mobile.app.model.LoginResponse;

public class SessionPrefs {

    private static SessionPrefs INSTANCE;

    public static SessionPrefs get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SessionPrefs(context);
        }
        return INSTANCE;
    }

    private SessionPrefs(Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREF_user_ID, Context.MODE_PRIVATE);

        mIsLoggedIn = !TextUtils.isEmpty(mPrefs.getString(PREF_user_TOKEN, null));
    }



    public static final String PREF_user_ID = "PREF_user_ID";
    public static final String PREF_user_EMAIL = "PREF_USER_EMAIL";
    public static final String PREF_user_TOKEN = "PREF_USER_TOKEN";

    private final SharedPreferences mPrefs;

    private boolean mIsLoggedIn;

    public boolean isLoggedIn(){
        return mIsLoggedIn;
    }

    public void saveAuthData(LoginResponse loginClient) {
        if (loginClient != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_user_ID, loginClient.getId()+"");
            editor.putString(PREF_user_EMAIL, loginClient.getEmail());
            editor.putString(PREF_user_TOKEN, loginClient.getJwt_token());
            editor.apply();

            mIsLoggedIn = true;
        }
    }

    public static String getToken(Context context){
        String token = "Bearer ";
        token = token.concat(SessionPrefs.get(context).mPrefs.getString(PREF_user_TOKEN, null));
        return token;
    }
}
