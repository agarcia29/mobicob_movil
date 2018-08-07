package com.example.analistasistemas.pruebasqllte.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.analistasistemas.pruebasqllte.model.User;

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

    private boolean mIsLoggedIn = false;

    public boolean isLoggedIn(){
        return mIsLoggedIn;
    }

    public void saveUser(User user) {
        if (user != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(PREF_user_EMAIL, user.getEmail());
            editor.putInt(PREF_user_ID, user.getId_number());
            editor.putString(PREF_user_TOKEN, user.getToken());
            editor.apply();

            mIsLoggedIn = true;
        }
    }
}
