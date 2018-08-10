package com.mobicob.mobile.app.wrappers;

import com.mobicob.mobile.app.model.TasksClient;

public class TaskResponseWrapper
{
    private TasksClient data;


    public TaskResponseWrapper() {
        setData(new TasksClient());
    }


    public TasksClient getData() {
        return data;
    }

    public void setData(TasksClient data) {
        this.data = data;
    }
}
