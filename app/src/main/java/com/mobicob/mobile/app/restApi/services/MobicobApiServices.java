package com.mobicob.mobile.app.restApi.services;

import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.wrappers.LoginRequestWrapper;
import com.mobicob.mobile.app.model.PendingClient;
import com.mobicob.mobile.app.wrappers.TaskResponseWrapper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MobicobApiServices {



    @GET("tasks")
    Call<TaskResponseWrapper> tasks(@Header("Authorization") String token);

    @GET("pendingClients")
    Call<ArrayList<PendingClient>> getPendClient();

    @POST("sign_in")
    Call<LoginResponse> login(@Body LoginRequestWrapper loginRequestWrapper);

}