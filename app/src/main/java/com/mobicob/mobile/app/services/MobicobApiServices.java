package com.mobicob.mobile.app.services;

import com.mobicob.mobile.app.data.prefs.SessionPrefs;
import com.mobicob.mobile.app.model.TaskResponse;
import com.mobicob.mobile.app.model.TasksList;
import com.mobicob.mobile.app.wrappers.LoginResponseWrapper;
import com.mobicob.mobile.app.wrappers.LoginRequestWrapper;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.PendingClient;
import com.mobicob.mobile.app.wrappers.TaskResponseWrapper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MobicobApiServices {



    @GET("tasks")
    Call<ArrayList<TaskResponse>> getAssigment(@Header("Authorization") String token);

    @GET("pendingClients")
    Call<ArrayList<PendingClient>> getPendClient();

    @POST("sign_in")
    Call<LoginResponseWrapper> login(@Body LoginRequestWrapper loginRequestWrapper);

}