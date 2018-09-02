package com.mobicob.mobile.app.wrapper;

import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.db.entity.User;

import java.util.List;

public class ResultRequestWrapper {
    private Task tasks;

    public ResultRequestWrapper(int email, String password) {
        setTasks(new Task());
        getTasks().setAnomalyTypeId(email) ;
      //  getTasks().setPassword(password);
    }

    public Task getTasks() {
        return tasks;
    }

    public void setTasks(Task tasks) {
        this.tasks = tasks;
    }
}