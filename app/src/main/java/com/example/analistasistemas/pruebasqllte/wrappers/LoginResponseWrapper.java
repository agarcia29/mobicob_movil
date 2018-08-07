package com.example.analistasistemas.pruebasqllte.wrappers;

import com.example.analistasistemas.pruebasqllte.model.LoginResponse;

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
