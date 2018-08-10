package com.mobicob.mobile.app.restApi.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.TaskResponse;
import com.mobicob.mobile.app.model.TasksClient;
import com.mobicob.mobile.app.restApi.JsonKeys;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TaskDeserializer implements JsonDeserializer<TaskResponse>{

    @Override
    public TaskResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson= new Gson();
        TaskResponse taskResponse = gson.fromJson(json, TaskResponse.class);
        JsonArray taskResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.TASK_RESPONSE_ARRAY);

        taskResponse.setTasks(deserealizerTasksClientToJson(taskResponseData));

        return taskResponse;
    }

    private ArrayList<TasksClient> deserealizerTasksClientToJson(JsonArray taskResponseData){
        ArrayList<TasksClient> tasks = new ArrayList<>();
        for (int i = 0; i < taskResponseData.size(); i++) {
            JsonObject taskResponseClient = taskResponseData.get(i).getAsJsonObject();
            JsonObject clientJson = taskResponseClient.getAsJsonObject(JsonKeys.CLIENT);
            String nic              = clientJson.get(JsonKeys.CLIENT_NIC).getAsString();
            String address          = clientJson.get(JsonKeys.CLIENT_ADDRESS).getAsString();
            String neighborhood     = clientJson.get(JsonKeys.CLIENT_NEIGHBORHOOD).getAsString();
            String municipality     = clientJson.get(JsonKeys.CLIENT_MUNICIPALITY).getAsString();
            String corregimiento    = clientJson.get(JsonKeys.CLIENT_CORREGIMIENTO).getAsString();
            String departamento     = clientJson.get(JsonKeys.CLIENT_DEPARTMENT).getAsString();

            TasksClient actualTask = new TasksClient();
            actualTask.setNic(nic);
            actualTask.setAddress(address);
            actualTask.setNeighborhood(neighborhood);
            actualTask.setMunicipalty(municipality);
            actualTask.setCorregimiento(corregimiento);
            actualTask.setDepartment(departamento);

            tasks.add(actualTask);
        }
        return tasks;
    }
}
