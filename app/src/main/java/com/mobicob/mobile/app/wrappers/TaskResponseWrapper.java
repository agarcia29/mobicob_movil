package com.mobicob.mobile.app.wrappers;

import com.mobicob.mobile.app.model.TasksResponse;

public class TaskResponseWrapper {
    private TasksResponse data;


    public TaskResponseWrapper() {
        setData(new TasksResponse());
    }


    public TasksResponse getData() {
        return data;
    }

    public void setData(TasksResponse data) {
        this.data = data;
    }
}
