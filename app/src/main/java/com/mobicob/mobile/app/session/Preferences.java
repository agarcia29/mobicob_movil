package com.mobicob.mobile.app.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.mobicob.mobile.app.model.LoginResponse;

public class Preferences {

    private static Preferences INSTANCE;

    public static Preferences get(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Preferences(context);
        }
        return INSTANCE;
    }

    private Preferences(Context context) {
        mPrefs = context.getApplicationContext()
                .getSharedPreferences(PREF_user_ID, Context.MODE_PRIVATE);
    }

    public static final String PREF_user_ID = "PREF_user_ID";
    public static final String PREF_user_EMAIL = "PREF_USER_EMAIL";
    public static final String PREF_user_TOKEN = "PREF_USER_TOKEN";

    private final SharedPreferences mPrefs;

    public boolean isLoggedIn(){

        return !TextUtils.isEmpty(mPrefs.getString(PREF_user_TOKEN, null));
    }

    public void saveAuthData(LoginResponse loginClient) {
        if (loginClient != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_user_ID, loginClient.getId()+"");
            editor.putString(PREF_user_EMAIL, loginClient.getEmail());
            editor.putString(PREF_user_TOKEN, loginClient.getJwt_token());
            editor.apply();
        }
    }

    public void sessionDestroy() {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_user_ID, null);
            editor.putString(PREF_user_EMAIL, null);
            editor.putString(PREF_user_TOKEN, null);
            editor.apply();
    }

    public static String getToken(Context context){
        String token = "Bearer ";
        token = token.concat(Preferences.get(context).mPrefs.getString(PREF_user_TOKEN, null));
        return token;
    }
}
