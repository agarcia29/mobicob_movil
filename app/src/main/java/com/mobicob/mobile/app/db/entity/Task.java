package com.mobicob.mobile.app.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Task extends ArrayList<Task> implements Serializable {

    @PrimaryKey
    @NonNull
    private int id;
    private String validity;
    private String createdAt;
    private int campaignId;
    private int clientId;
    private int period;
    private String plan;
    private int userId;
    private String dueDate;
    private String estimatedTime;
    private String updateAt;
    private String managementDate;
    private int managementTypeId;
    private int resultTypeId;
    private int anomalyTypeId;
    private String collectionEntity;
    private String paymentDate;
    private String commitmentDate;
    private int personalContact;
    private int Idnumber;
    private String paymentHolder;
    private String phone;
    private String email;
    private String observations;
    private int readingSignature;
    private int dataphonePayment;
    private int latitude;
    private int longitude;
    private String usedTime;


    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

       public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getManagementDate() {
        return managementDate;
    }

    public void setManagementDate(String managementDate) {
        this.managementDate = managementDate;
    }

    public int getManagementTypeId() {
        return managementTypeId;
    }

    public void setManagementTypeId(int managementTypeId) {
        this.managementTypeId = managementTypeId;
    }

    public int getResultTypeId() {
        return resultTypeId;
    }

    public void setResultTypeId(int resultTypeId) {
        this.resultTypeId = resultTypeId;
    }

    public int getAnomalyTypeId() {
        return anomalyTypeId;
    }

    public void setAnomalyTypeId(int anomalyTypeId) {
        this.anomalyTypeId = anomalyTypeId;
    }

    public String getCollectionEntity() {
        return collectionEntity;
    }

    public void setCollectionEntity(String collectionEntity) {
        this.collectionEntity = collectionEntity;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCommitmentDate() {
        return commitmentDate;
    }

    public void setCommitmentDate(String commitmentDate) {
        this.commitmentDate = commitmentDate;
    }

    public int getPersonalContact() {
        return personalContact;
    }

    public void setPersonalContact(int personalContact) {
        this.personalContact = personalContact;
    }

    public int getIdnumber() {
        return Idnumber;
    }

    public void setIdnumber(int idnumber) {
        Idnumber = idnumber;
    }

    public String getPaymentHolder() {
        return paymentHolder;
    }

    public void setPaymentHolder(String paymentHolder) {
        this.paymentHolder = paymentHolder;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public int getReadingSignature() {
        return readingSignature;
    }

    public void setReadingSignature(int readingSignature) {
        this.readingSignature = readingSignature;
    }

    public int getDataphonePayment() {
        return dataphonePayment;
    }

    public void setDataphonePayment(int dataphonePayment) {
        this.dataphonePayment = dataphonePayment;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(String usedTime) {
        this.usedTime = usedTime;
    }
}
