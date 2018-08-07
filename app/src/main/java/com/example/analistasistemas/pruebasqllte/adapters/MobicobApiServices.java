package com.example.analistasistemas.pruebasqllte.adapters;
import android.content.SharedPreferences;

import com.example.analistasistemas.pruebasqllte.model.Data;
import com.example.analistasistemas.pruebasqllte.model.Tasks;
import com.example.analistasistemas.pruebasqllte.model.PendingClient;
import com.example.analistasistemas.pruebasqllte.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MobicobApiServices {

    @Headers({
            "Authorization", "Bearer "+ ""
    })

    @GET("tasks")
    Call<ArrayList<Tasks>> getAssigment();

    @GET("pendingClients")
    Call<ArrayList<PendingClient>> getPendClient();

    @POST("sign_in")
    Call<DataBody> login(@Body LoginBody loginBody);

}