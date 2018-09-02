package com.mobicob.mobile.app.model;

import com.mobicob.mobile.app.db.entity.Task;

public class ResultResponse {
    private  int id;
    private Task task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
