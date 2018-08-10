package com.mobicob.mobile.app.model;

public class LoginClient {
private String id;
private String email;
private String jwt_token;

public String getId() {
        return id;
        }

public void setId(String id) {
        this.id = id;
        }

public String getEmail() {
        return email;
        }

public void setEmail(String email) {
        this.email = email;
        }

public String getJwt_token() {
        return jwt_token;
        }

public void setJwt_token(String jwt_token) {
        this.jwt_token = jwt_token;
        }
}
