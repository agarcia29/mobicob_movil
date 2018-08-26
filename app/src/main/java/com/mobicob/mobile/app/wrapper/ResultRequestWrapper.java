package com.mobicob.mobile.app.wrapper;

import com.mobicob.mobile.app.db.entity.Task;
import java.util.List;

public class ResultRequestWrapper {
    private List<Task> tasks;

    public  ResultRequestWrapper (List<Task> tasks){
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}