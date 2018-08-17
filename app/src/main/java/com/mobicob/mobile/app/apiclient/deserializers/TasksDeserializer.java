package com.mobicob.mobile.app.apiclient.deserializers;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mobicob.mobile.app.model.Campaign;
import com.mobicob.mobile.app.model.Client;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.apiclient.JsonKeys;
import com.mobicob.mobile.app.util.DateUtilities;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class TasksDeserializer implements JsonDeserializer<TasksResponse> {

   @Override
    public TasksResponse deserialize(
            JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            TasksResponse tasksResp;
            JsonObject responseJson = json.getAsJsonObject();
            tasksResp = mapJsonToTasksResponse(responseJson);

            return tasksResp;
        } catch (Exception e) {
            Log.e("MOBICOB", e.getMessage(), e);
            throw  new JsonParseException(e);
        }
    }

    private TasksResponse mapJsonToTasksResponse(JsonObject responseJson) throws Exception{
        TasksResponse tasksResp = new TasksResponse();
        ArrayList<Task> tasks = new ArrayList<Task>();
        Task tempTask;
        Client tempClient;
        Campaign tempCampaign;
        JsonObject tempObject;
        JsonObject client;
        JsonObject campaign;

        JsonObject data = responseJson.getAsJsonObject(JsonKeys.DATA_RESPONSE_OBJECT);
        JsonArray TaskArray = data.getAsJsonArray(JsonKeys.TASK_RESPONSE_ARRAY);
        for (int i = 0; i < TaskArray.size() ; i++) {
            tempClient = new Client();
            tempTask = new Task();
            tempCampaign = new Campaign();
            tempObject = TaskArray.get(i).getAsJsonObject();
            tempTask.setId(getAsInt(tempObject.get(JsonKeys.LOGIN_ID)));
            tempTask.setPeriod(getAsInt(tempObject.get(JsonKeys.TASK_PERIOD)));
            tempTask.setPlan(getAsString(tempObject.get(JsonKeys.TASK_PERIOD)));
            tempTask.setValidity(getAsString(tempObject.get(JsonKeys.TASK_VALIDITY)));
            //tempTask.setCreatedAt(tempObject.get(JsonKeys.TASK_CAMPAIGN_CREATED)));
            //tempTask.setUpdateAt(tempObject.get(JsonKeys.TASK_CAMPAIGN_UPDATED)));
            //tempTask.setDueDate(tempObject.get(JsonKeys.TASK_DUE)));
            //tempTask.setEstimatedTime(tempObject.get(JsonKeys.TASK_ESTIMATED));
            tempTask.setUserId(getAsInt(tempObject.get(JsonKeys.TASK_USER_ID)));
            client = tempObject.getAsJsonObject(JsonKeys.CLIENT);
            tempClient.setId(getAsInt(client.get(JsonKeys.LOGIN_ID)));
            tempClient.setNic(getAsInt(client.get(JsonKeys.CLIENT_NIC)));
            tempClient.setUnicom(getAsString(client.get(JsonKeys.CLIENT_UNICOM)));
            tempClient.setNisRad(getAsInt(client.get(JsonKeys.CLIENT_NIS)));
            tempClient.setDepartament(getAsString(client.get(JsonKeys.CLIENT_DEPARTMENT)));
            tempClient.setMunicipality(getAsString(client.get(JsonKeys.CLIENT_MUNICIPALITY)));
            tempClient.setCorregimiento(getAsString(client.get(JsonKeys.CLIENT_CORREGIMIENTO)));
            tempClient.setNeighborhood(getAsString(client.get(JsonKeys.CLIENT_NEIGHBORHOOD)));
            tempClient.setStreetType(getAsString(client.get(JsonKeys.CLIENT_STREET_TYPE)));
            tempClient.setStreetName(getAsString(client.get(JsonKeys.CLIENT_STREET_NAME)));
            tempClient.setDuplicator(getAsString(client.get(JsonKeys.CLIENT_DUPLICATOR)));
            tempClient.setNumber(getAsInt(client.get(JsonKeys.CLIENT_NUMBER)));
            tempClient.setCgv(getAsString(client.get(JsonKeys.CLIENT_CGV)));
            tempClient.setAddress(getAsString(client.get(JsonKeys.CLIENT_ADDRESS)));
            tempClient.setName(getAsString(client.get(JsonKeys.CLIENT_NAME)));
            tempClient.setIdNumber(getAsInt(client.get(JsonKeys.CLIENT_ID_NUMBER)));
            tempClient.setPhone(getAsString(client.get(JsonKeys.CLIENT_PHONE)));
            tempClient.setRate(getAsString(client.get(JsonKeys.CLIENT_RATE)));
            tempClient.setState(getAsString(client.get(JsonKeys.CLIENT_STATE)));
            tempClient.setRoute(getAsInt(client.get(JsonKeys.CLIENT_ROUTE)));
            tempClient.setReadingItinerary(getAsInt(client.get(JsonKeys.CLIENT_IT_READ)));
            tempClient.setaOLFinca(getAsInt(client.get(JsonKeys.CLIENT_AOL)));
            tempClient.setMeasurer(getAsString(client.get(JsonKeys.CLIENT_MEASURER)));
            tempClient.setMeasurerType(getAsString(client.get(JsonKeys.CLIENT_MEASURER_TYPE)));
            tempClient.setMeasurerBrand(getAsString(client.get(JsonKeys.CLIENT_MEASURER_BRAND)));
            tempClient.setEnergyDebt(getAsInt(client.get(JsonKeys.CLIENT_ENERGY_DEBT)));
            tempClient.setIrregularDebt(getAsInt(client.get(JsonKeys.CLIENT_IRREGULAR_DEBT)));
            tempClient.setThirdPartyDebt(getAsInt(client.get(JsonKeys.CLIENT_THIRD_PARTY_DEBT)));
            tempClient.setFinancedDebt(getAsInt(client.get(JsonKeys.CLIENT_FINANCED_DEBT)));
            tempClient.setOverdueBills(getAsInt(client.get(JsonKeys.CLIENT_OVERDUE_BILLS)));
            tempClient.setAgreedBills(getAsInt(client.get(JsonKeys.CLIENT_AGREED_BILLS)));
            tempClient.setCreatedAt(getAsDate(client.get(JsonKeys.TASK_CAMPAIGN_CREATED)));
            //tempClient.setUpdatedAt(client.get(JsonKeys.TASK_CAMPAIGN_UPDATED)));
            tempClient.setDelegation_id(getAsInt(client.get(JsonKeys.CLIENT_DELEGATION_ID)));
            tempTask.setClient(tempClient);

            campaign = tempObject.getAsJsonObject(JsonKeys.TASK_CAMPAIGN);
            tempCampaign.setId(getAsInt(campaign.get(JsonKeys.LOGIN_ID)));
            tempCampaign.setNumber(getAsInt(campaign.get(JsonKeys.TASK_CAMPAIGN_NUMBER)));
            tempCampaign.setSource(getAsString(campaign.get(JsonKeys.TASK_CAMPAIGN_SOURCE)));
            tempCampaign.setState(getAsString(campaign.get(JsonKeys.CLIENT_STATE)));
            //tempCampaign.setInitDate(campaign.get(JsonKeys.TASK_CAMPAIGN_IDATE)));
            //tempCampaign.setFinishDate(campaign.get(JsonKeys.TASK_CAMPAIGN_FDATE)));
            //tempCampaign.setCreatedAt(campaign.get(JsonKeys.TASK_CAMPAIGN_CREATED)));
            //tempCampaign.setUpdatedAt(campaign.get(JsonKeys.TASK_CAMPAIGN_UPDATED)));
            tempTask.setCampaign(tempCampaign);
            tasks.add(tempTask);


        }
        tasksResp.setTasks(tasks);
        return tasksResp;
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
