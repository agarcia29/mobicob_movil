package com.example.analistasistemas.pruebasqllte.model;

import java.util.Date;

public class Assignment {
    private int taskId;
    private int userId;
    private Date dueDate;
    private Date stimatedTime;
    private Date createdAt;
    private Date managementDate;
    private int managementType;
    private int resultTypeID;
    private int anomalyTypeID;
    private String collectionEntity;
    private Date paymentDate;
    private Date commitmentDate;
    private boolean personalContact;
    private int idNumber;
    private String paymentHolder;
    private String phone;
    private String email;
    private String observations;
    private int readingSignature;
    private int latitude;
    private int longitude;


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getStimatedTime() {
        return stimatedTime;
    }

    public void setStimatedTime(Date stimatedTime) {
        this.stimatedTime = stimatedTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getManagementDate() {
        return managementDate;
    }

    public void setManagementDate(Date managementDate) {
        this.managementDate = managementDate;
    }

    public int getManagementType() {
        return managementType;
    }

    public void setManagementType(int managementType) {
        this.managementType = managementType;
    }

    public int getResultTypeID() {
        return resultTypeID;
    }

    public void setResultTypeID(int resultTypeID) {
        this.resultTypeID = resultTypeID;
    }

    public int getAnomalyTypeID() {
        return anomalyTypeID;
    }

    public void setAnomalyTypeID(int anomalyTypeID) {
        this.anomalyTypeID = anomalyTypeID;
    }

    public String getCollectionEntity() {
        return collectionEntity;
    }

    public void setCollectionEntity(String collectionEntity) {
        this.collectionEntity = collectionEntity;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getCommitmentDate() {
        return commitmentDate;
    }

    public void setCommitmentDate(Date commitmentDate) {
        this.commitmentDate = commitmentDate;
    }

    public boolean isPersonalContact() {
        return personalContact;
    }

    public void setPersonalContact(boolean personalContact) {
        this.personalContact = personalContact;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
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
}
