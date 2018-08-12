package com.mobicob.mobile.app.restApi.network;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.restApi.deserializers.LoginDeserializer;
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
        GsonConverterFactory factory;
        if(gson!=null) {
            factory = GsonConverterFactory.create(gson);
        }
        else{
            factory = GsonConverterFactory.create();
        }

        if (API_SERVICES == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(factory)
                    .client(httpClient.build())
                    .build();
            API_SERVICES = retrofit.create(MobicobApiServices.class);
        }
        return API_SERVICES;
    }

 /*   public static Gson buildTasksGson(){
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
*/
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

