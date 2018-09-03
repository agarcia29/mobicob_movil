package com.mobicob.mobile.app.apiclient.deserializers;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mobicob.mobile.app.apiclient.JsonKeys;
import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.db.entity.Campaign;
import com.mobicob.mobile.app.db.entity.Client;
import com.mobicob.mobile.app.db.entity.ManagementType;
import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.model.ParamsResponse;
import com.mobicob.mobile.app.model.ParamsResponse;
import com.mobicob.mobile.app.util.DateUtilities;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class ParamsDeserealizer implements JsonDeserializer<ParamsResponse> {

    @Override
    public ParamsResponse deserialize(
            JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            ParamsResponse paramsResp;
            JsonObject responseJson = json.getAsJsonObject();
            paramsResp = mapJsonToParamsResponse(responseJson);

            return paramsResp;
        } catch (Exception e) {
            Log.e("MOBICOB", e.getMessage(), e);
            throw  new JsonParseException(e);
        }
    }

    private ParamsResponse mapJsonToParamsResponse(JsonObject responseJson) throws Exception{
        ParamsResponse paramsResp = new ParamsResponse();
        ArrayList<ManagementType> managementTypes = new ArrayList<ManagementType>();
        ArrayList<ResultType> resultTypes = new ArrayList<ResultType>();
        ArrayList<AnomalyType> anomalyTypes = new ArrayList<AnomalyType>();
        ManagementType tempManagementType;
        ResultType tempResultType;
        AnomalyType tempAnomalyType;
        JsonObject tempObject;
        JsonObject client;
        JsonObject campaign;

        JsonObject data = responseJson.getAsJsonObject(JsonKeys.DATA_RESPONSE_OBJECT);
        JsonArray ManagementTypeArray = data.getAsJsonArray(JsonKeys.MANAGEMENT_TYPE_RESPONSE_ARRAY);
        JsonArray ResultTypeArray = data.getAsJsonArray(JsonKeys.RESULT_TYPE_RESPONSE_ARRAY);
        JsonArray AnomalyTypeArray = data.getAsJsonArray(JsonKeys.ANOMALY_TYPE_RESPONSE_ARRAY);
        for (int i = 0; i < ManagementTypeArray.size() ; i++) {
            tempManagementType = new ManagementType();
            tempObject = ManagementTypeArray.get(i).getAsJsonObject();
            tempManagementType.setId(getAsInt(tempObject.get(JsonKeys.LOGIN_ID)));
            tempManagementType.setCode(getAsString(tempObject.get(JsonKeys.CODE_PARAMS)));
            tempManagementType.setName(getAsString(tempObject.get(JsonKeys.NAME_PARAMS)));
            tempManagementType.setDescription(getAsString(tempObject.get(JsonKeys.DESCRIPTION_PARAMS)));

            managementTypes.add(tempManagementType);
        }
        for (int i = 0; i < ManagementTypeArray.size() ; i++) {
            tempResultType = new ResultType();
            tempObject = ManagementTypeArray.get(i).getAsJsonObject();
            tempResultType.setId(getAsInt(tempObject.get(JsonKeys.LOGIN_ID)));
            tempResultType.setCode(getAsString(tempObject.get(JsonKeys.CODE_PARAMS)));
            tempResultType.setName(getAsString(tempObject.get(JsonKeys.NAME_PARAMS)));
            tempResultType.setDescription(getAsString(tempObject.get(JsonKeys.DESCRIPTION_PARAMS)));

            resultTypes.add(tempResultType);


        }
        for (int i = 0; i < ManagementTypeArray.size() ; i++) {
            tempAnomalyType = new AnomalyType();
            tempObject = ManagementTypeArray.get(i).getAsJsonObject();
            tempAnomalyType.setId(getAsInt(tempObject.get(JsonKeys.LOGIN_ID)));
            tempAnomalyType.setCode(getAsString(tempObject.get(JsonKeys.CODE_PARAMS)));
            tempAnomalyType.setName(getAsString(tempObject.get(JsonKeys.NAME_PARAMS)));
            tempAnomalyType.setDescription(getAsString(tempObject.get(JsonKeys.DESCRIPTION_PARAMS)));

            anomalyTypes.add(tempAnomalyType);
        }
        paramsResp.setManagementType(managementTypes);
        paramsResp.setResultType(resultTypes);
        paramsResp.setAnomalyType(anomalyTypes);
        return paramsResp;
    }

    private int getAsInt(JsonElement element){
        if(element != null && (element.getClass() != JsonNull.class)){
            return element.getAsInt();
        }
        return 0;
    }

    private String getAsString(JsonElement element){
        if(element != null && (element.getClass() != JsonNull.class)){
            return element.getAsString();
        }
        return "";
    }

    private Date getAsDate(JsonElement element){
        if(element != null && (element.getClass() != JsonNull.class)){
            Date myDate = DateUtilities.stringToDate(element.getAsString());
            return myDate;
        }
        return null;
    }
}

