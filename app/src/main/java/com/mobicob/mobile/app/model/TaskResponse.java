package com.mobicob.mobile.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TaskResponse {


    @SerializedName("tasks")
    private ArrayList<TasksClient> tasks;


    public ArrayList<TasksClient> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<TasksClient> tasks) {
        this.tasks = tasks;
    }
}
