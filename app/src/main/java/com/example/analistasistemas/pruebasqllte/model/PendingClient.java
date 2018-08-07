package com.example.analistasistemas.pruebasqllte.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PendingClient {
    @SerializedName("pending_client")
    private ArrayList<Client> clientsList;


    public ArrayList<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(ArrayList<Client> clientsList) {
        this.clientsList = clientsList;
    }
}
