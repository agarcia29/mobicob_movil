package com.example.analistasistemas.pruebasqllte.adapters;
import com.example.analistasistemas.pruebasqllte.model.Assignment;
import com.example.analistasistemas.pruebasqllte.model.Client;
import com.example.analistasistemas.pruebasqllte.model.PendingClient;
import com.example.analistasistemas.pruebasqllte.model.User;
import com.example.analistasistemas.pruebasqllte.response.LoginResponse;

import java.util.ArrayList;

import retrofit2.Call;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MobicobApiServices {


    @GET("assignments")
    Call<ArrayList<Assignment>> getAssigment();

    @GET("pendingClients")
    Call<ArrayList<PendingClient>> getPendClient();

    @POST("sign_in")
    Call<User> login(@Body LoginBody loginBody);
}