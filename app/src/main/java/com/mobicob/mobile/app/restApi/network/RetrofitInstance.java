package com.mobicob.mobile.app.restApi.network;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobicob.mobile.app.model.TaskResponse;
import com.mobicob.mobile.app.restApi.deserializers.TaskDeserializer;
import com.mobicob.mobile.app.restApi.services.MobicobApiServices;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static MobicobApiServices API_SERVICES;

    public static MobicobApiServices getApiServices(final Context context, Gson gson){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient= new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = "http://192.168.1.14:3000/v1/";

        if (API_SERVICES == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
            API_SERVICES = retrofit.create(MobicobApiServices.class);
        }
        return API_SERVICES;
    }

    public static Gson gsonDeserealizerBuilderTaskClient(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(TaskResponse.class, new TaskDeserializer());

        return gsonBuilder.create();
    }
}

