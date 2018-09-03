package com.mobicob.mobile.app.model;

import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.db.entity.ManagementType;
import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.db.entity.Task;

import java.io.Serializable;
import java.util.List;

public class ParamsResponse implements Serializable {

    private List<ManagementType> ManagementType;
    private List<ResultType> ResultType;
    private List<AnomalyType> AnomalyType;


    public List<com.mobicob.mobile.app.db.entity.ManagementType> getManagementType() {
        return ManagementType;
    }

    public void setManagementType(List<com.mobicob.mobile.app.db.entity.ManagementType> managementType) {
        ManagementType = managementType;
    }

    public List<com.mobicob.mobile.app.db.entity.ResultType> getResultType() {
        return ResultType;
    }

    public void setResultType(List<com.mobicob.mobile.app.db.entity.ResultType> resultType) {
        ResultType = resultType;
    }

    public List<com.mobicob.mobile.app.db.entity.AnomalyType> getAnomalyType() {
        return AnomalyType;
    }

    public void setAnomalyType(List<com.mobicob.mobile.app.db.entity.AnomalyType> anomalyType) {
        AnomalyType = anomalyType;
    }
}
