package com.mobicob.mobile.app.wrappers;

import com.mobicob.mobile.app.model.Client;
import com.mobicob.mobile.app.model.LoginResponse;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.TaskResponse;
import com.mobicob.mobile.app.model.TasksList;

public class TaskResponseWrapper
{
    private TasksList data;


    public TaskResponseWrapper() {
        setData(new TasksList());
    }


    public TasksList getData() {
        return data;
    }

    public void setData(TasksList data) {
        this.data = data;
    }
}
