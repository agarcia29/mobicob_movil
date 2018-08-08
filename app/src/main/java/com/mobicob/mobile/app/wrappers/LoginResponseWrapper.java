package com.mobicob.mobile.app.wrappers;

import com.mobicob.mobile.app.model.LoginResponse;

public class LoginResponseWrapper {
    private LoginResponse data;

    public LoginResponseWrapper(String email, String jwt_token) {
        setData(new LoginResponse());
        getData().setEmail(email);
        getData().setJwt_token(jwt_token);
    }


    public LoginResponse getData() {
        return data;
    }

    public void setData(LoginResponse data) {
        this.data = data;
    }
}
