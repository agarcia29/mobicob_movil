package com.mobicob.mobile.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TasksList {

        @SerializedName("tasks")
        private ArrayList<TaskResponse> tasks;


    public ArrayList<TaskResponse> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<TaskResponse> tasks) {
        this.tasks = tasks;
    }
}
