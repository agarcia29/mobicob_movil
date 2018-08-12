package com.mobicob.mobile.app.restApi.network;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.restApi.deserializers.LoginDeserializer;
import com.mobicob.mobile.app.restApi.deserializers.TasksDeserializer;
import com.mobicob.mobile.app.restApi.services.MobicobApiServices;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static MobicobApiServices API_SERVICES_LOGIN;
    private static MobicobApiServices API_SERVICES_TASK;

    public static MobicobApiServices getApiServicesLogin(final Context context){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient= new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = "https://a7092694-1155-4872-b9e7-c64c40905210.mock.pstmn.io/";
        GsonConverterFactory loginFactory;
        GsonConverterFactory tasksFactory;

        loginFactory = GsonConverterFactory.create(buildLoginGson());

        if (API_SERVICES_LOGIN == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(loginFactory)
                    .client(httpClient.build())
                    .build();
            API_SERVICES_LOGIN = retrofit.create(MobicobApiServices.class);
        }
        return API_SERVICES_LOGIN;
    }

    public static MobicobApiServices getApiServicesTask(final Context context){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient= new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = "https://a7092694-1155-4872-b9e7-c64c40905210.mock.pstmn.io/";
        GsonConverterFactory loginFactory;
        GsonConverterFactory tasksFactory;

        tasksFactory = GsonConverterFactory.create(buildTasksGson());

        if (API_SERVICES_TASK == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(tasksFactory)
                    .client(httpClient.build())
                    .build();
            API_SERVICES_TASK = retrofit.create(MobicobApiServices.class);
        }
        return API_SERVICES_TASK;
    }
    public static Gson buildTasksGson(){
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(TasksResponse.class, new TasksDeserializer());
            return gsonBuilder.create();
        }
        catch(Exception e){
            Log.e("MOBICOB", e.getMessage(), e);
        }
        return null;
    }

    public static Gson buildLoginGson(){
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LoginResponse.class, new LoginDeserializer());
            return gsonBuilder.create();
        }
        catch(Exception e){
            Log.e("MOBICOB", e.getMessage(), e);
        }
        return null;
    }
}

