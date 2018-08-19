package com.mobicob.mobile.app.wrapper;

import com.mobicob.mobile.app.model.Result;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.User;

import java.util.Date;

public class ResultRequestWrapper {
    private Task taskRequest;

    public  ResultRequestWrapper (Task task, Result result){
        task.setUpdateAt(result.getUpdateAt());
        task.setUser(result.getUser());
        task.setManagementDate(result.getManagementDate());
        task.setManagementTypeId(result.getManagementTypeId());
        task.setResultTypeId(result.getResultTypeId());
        task.setAnomalyTypeId(result.getAnomalyTypeId());
        task.setCollectionEntity(result.getCollectionEntity());
        task.setPaymentDate(result.getPaymentDate());
        task.setCommitmentDate(result.getCommitmentDate());
        task.setPersonalContact(result.isPersonalContact());
        task.setIdnumber(result.getIdnumber());
        task.setPaymentHolder(result.getPaymentHolder());
        task.setPhone(result.getPhone());
        task.setEmail(result.getEmail());
        task.setObservations(result.getObservations());
        task.setReadingSignature(result.getReadingSignature());
        task.setDataphonePayment(result.isDataphonePayment());
        task.setLatitude(result.getLatitude());
        task.setLongitude(result.getLongitude());
        task.setUsedTime(result.getUsedTime());
        setTaskRequest(task);
    }

    public Task getTaskRequest() {
        return taskRequest;
    }

    public void setTaskRequest(Task taskRequest) {
        this.taskRequest = taskRequest;
    }
}
