package com.mobicob.mobile.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TasksList {

        @SerializedName("tasks")
        private ArrayList<Task> taskList;

        public ArrayList<Task> getTaskArrayList() {
            return taskList;
        }

        public void setTaskArrayList(ArrayList<Task> taskArrayList) {
            this.taskList = taskArrayList;
        }
}
