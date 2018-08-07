package com.example.analistasistemas.pruebasqllte.wrappers;

import com.example.analistasistemas.pruebasqllte.model.User;

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

