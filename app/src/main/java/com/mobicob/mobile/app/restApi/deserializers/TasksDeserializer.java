package com.mobicob.mobile.app.restApi.deserializers;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.restApi.JsonKeys;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TasksDeserializer {

   /** @Override
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
        JsonObject tempObject;

        JsonObject data = responseJson.getAsJsonObject(JsonKeys.DATA_RESPONSE_OBJECT);
        JsonArray jsonArray = data.getAsJsonArray(JsonKeys.TASK_RESPONSE_ARRAY);

        for (JsonElement element: jsonArray){
            tempTask = new Task();
            tempObject = element.getAsJsonObject();
            tempTask.setId(tempObject.get("id").getAsInt());
            tempTask.setPeriod(tempObject.get("period").getAsInt());

            tasks.add(tempTask);
        }
        tasksResp.setTasks(tasks);
        return tasksResp;
    }*/
}
