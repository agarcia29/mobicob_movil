package com.example.analistasistemas.pruebasqllte.adapters;

import com.example.analistasistemas.pruebasqllte.model.User;

public class LoginBody {
    private User user;

    public LoginBody(String email, String password) {
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

