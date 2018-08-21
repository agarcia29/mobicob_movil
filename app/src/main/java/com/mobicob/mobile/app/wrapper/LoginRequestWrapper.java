package com.mobicob.mobile.app.wrapper;

import com.mobicob.mobile.app.model.User;

public class LoginRequestWrapper {
    private User user;

    public LoginRequestWrapper(String email, String password) {
        setUser(new User());
        getUser().setEmail(email);
        getUser().setPassword(password);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

