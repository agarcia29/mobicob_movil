package com.mobicob.mobile.app.model;

public class TaskResponse {
    private Client client;
    private Task task;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
