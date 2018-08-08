package com.mobicob.mobile.app.services;

import com.mobicob.mobile.app.wrappers.LoginResponseWrapper;
import com.mobicob.mobile.app.wrappers.LoginRequestWrapper;
import com.mobicob.mobile.app.model.Tasks;
import com.mobicob.mobile.app.model.PendingClient;

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
    Call<LoginResponseWrapper> login(@Body LoginRequestWrapper loginRequestWrapper);

}