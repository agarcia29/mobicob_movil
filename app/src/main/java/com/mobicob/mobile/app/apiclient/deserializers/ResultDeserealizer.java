package com.mobicob.mobile.app.apiclient.deserializers;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mobicob.mobile.app.apiclient.JsonKeys;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.model.ResultResponse;

import java.lang.reflect.Type;

public class ResultDeserealizer implements JsonDeserializer<ResultResponse> {
    @Override
    public ResultResponse deserialize(
            JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            ResultResponse resultResp = new ResultResponse();

            JsonObject responseJson = json.getAsJsonObject();
            JsonObject data = responseJson.getAsJsonObject(JsonKeys.DATA_RESPONSE_OBJECT);
           /* resultResp.setId(data.get(JsonKeys.LOGIN_ID).getAsInt());
            resultResp.setEmail(data.get(JsonKeys.LOGIN_EMAIL).getAsString());
            resultResp.setJwt_token(data.get(JsonKeys.LOGIN_JWT_TOKEN).getAsString());
*/
            return resultResp;
        } catch (Exception e) {
            Log.e("MOBICOB", e.getMessage(), e);
            throw  new JsonParseException(e);
        }
    }
}
