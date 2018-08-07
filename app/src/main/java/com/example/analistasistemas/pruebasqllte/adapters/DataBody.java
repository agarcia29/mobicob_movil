package com.example.analistasistemas.pruebasqllte.adapters;

import com.example.analistasistemas.pruebasqllte.model.Data;

public class DataBody {
    private Data data;

    public DataBody(String email, String jwt_token) {
        setData(new Data());
        getData().setEmail(email);
        getData().setJwt_token(jwt_token);
    }


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
