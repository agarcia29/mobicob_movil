package com.mobicob.mobile.app.apiclient.services;

import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.wrapper.LoginRequestWrapper;
import com.mobicob.mobile.app.wrappers.ResultRequestWrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MobicobApiServices {

    @GET("tasks")
    Call<TasksResponse> tasks(@Header("Authorization") String token);

    @GET("result")
    Call<Task> result(@Header("Authorization") String token, @Body ResultRequestWrapper resultRequestWrapper);

    @POST("sign_in")
    Call<LoginResponse> login(@Body LoginRequestWrapper loginRequestWrapper);
}