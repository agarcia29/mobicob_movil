package com.mobicob.mobile.app.wrappers;

import com.mobicob.mobile.app.model.LoginClient;

public class LoginResponseWrapper {
    private LoginClient data;

    public LoginResponseWrapper(String email, String jwt_token) {
        setData(new LoginClient());
        getData().setEmail(email);
        getData().setJwt_token(jwt_token);
    }


    public LoginClient getData() {
        return data;
    }

    public void setData(LoginClient data) {
        this.data = data;
    }
}
