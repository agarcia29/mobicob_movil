package com.mobicob.mobile.app.apiclient.deserializers;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.apiclient.JsonKeys;

import java.lang.reflect.Type;

public class LoginDeserializer implements JsonDeserializer<LoginResponse> {

    @Override
    public LoginResponse deserialize(
            JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            LoginResponse loginResp = new LoginResponse();

            JsonObject responseJson = json.getAsJsonObject();
            JsonObject data = responseJson.getAsJsonObject(JsonKeys.DATA_RESPONSE_OBJECT);
            loginResp.setId(data.get(JsonKeys.LOGIN_ID).getAsInt());
            loginResp.setEmail(data.get(JsonKeys.LOGIN_EMAIL).getAsString());
            loginResp.setIdNumber(data.get(JsonKeys.LOGIN_ID_NUMBER).getAsString());
            loginResp.setName(data.get(JsonKeys.LOGIN_NAME).getAsString());
            loginResp.setLastname(data.get(JsonKeys.LOGIN_LASTNAME).getAsString());
            loginResp.setPosition(data.get(JsonKeys.LOGIN_POSITION).getAsString());
            loginResp.setJwt_token(data.get(JsonKeys.LOGIN_JWT_TOKEN).getAsString());

            JsonObject delegation = data.getAsJsonObject(JsonKeys.DELEGATION_LOGIN_OBJECT);
            loginResp.setDelegationId(delegation.get(JsonKeys.LOGIN_ID_OBJECT).getAsInt());

            JsonObject contractor = data.getAsJsonObject(JsonKeys.CONTRACTOR_LOGIN_OBJECT);
            loginResp.setContractorId(contractor.get(JsonKeys.LOGIN_ID_OBJECT).getAsInt());

            JsonObject role = data.getAsJsonObject(JsonKeys.ROLE_LOGIN_OBJECT);
            loginResp.setRoleId(role.get(JsonKeys.LOGIN_ID_OBJECT).getAsInt());


            return loginResp;
        } catch (Exception e) {
            Log.e("MOBICOB", e.getMessage(), e);
            throw  new JsonParseException(e);
        }
    }
}