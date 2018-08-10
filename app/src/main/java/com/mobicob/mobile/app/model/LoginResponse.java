package com.mobicob.mobile.app.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("data")
    private LoginClient client;

    public LoginClient getClient() {
        return client;
    }

    public void setClient(LoginClient client) {
        this.client = client;
    }
}
