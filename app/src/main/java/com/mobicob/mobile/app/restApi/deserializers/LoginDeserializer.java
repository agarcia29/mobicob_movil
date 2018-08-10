package com.mobicob.mobile.app.restApi.deserializers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mobicob.mobile.app.model.LoginClient;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.model.TaskResponse;
import com.mobicob.mobile.app.model.TasksClient;
import com.mobicob.mobile.app.restApi.JsonKeys;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class LoginDeserializer implements JsonDeserializer<LoginResponse> {

    @Override
    public LoginResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson= new Gson();
        LoginResponse loginResponse = gson.fromJson(json, LoginResponse.class);

        JsonObject loginResponseData = json.getAsJsonObject().getAsJsonObject();

        loginResponse.setClient(deserealizerLoginClientToJson(loginResponseData));

        return loginResponse;
    }

    private  LoginClient  deserealizerLoginClientToJson(JsonObject loginResponseData) {
        LoginClient login = new LoginClient();
        JsonObject loginResponseClient = loginResponseData.getAsJsonObject();
        String id = loginResponseClient.get(JsonKeys.LOGIN_ID).getAsString();
        String email = loginResponseClient.get(JsonKeys.LOGIN_EMAIL).getAsString();
        String jwt_token = loginResponseClient.get(JsonKeys.LOGIN_JWT_TOKEN).getAsString();

        login.setId(id);
        login.setEmail(email);
        login.setJwt_token(jwt_token);
    return login;
    }

}


