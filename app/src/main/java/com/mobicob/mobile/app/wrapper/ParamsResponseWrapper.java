package com.mobicob.mobile.app.wrapper;

import com.mobicob.mobile.app.model.ParamsResponse;
import com.mobicob.mobile.app.model.TasksResponse;

public class ParamsResponseWrapper {
    private ParamsResponse data;


    public ParamsResponseWrapper() {
        setData(new ParamsResponse());
    }

    public ParamsResponse getData() {
        return data;
    }

    public void setData(ParamsResponse data) {
        this.data = data;
    }
}
