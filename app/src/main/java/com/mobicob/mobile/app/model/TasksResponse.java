package com.mobicob.mobile.app.model;

import java.io.Serializable;
import java.util.List;

import com.mobicob.mobile.app.db.entity.Task;

public class TasksResponse implements Serializable {

    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
