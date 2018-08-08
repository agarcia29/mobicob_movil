package com.mobicob.mobile.app.model;

import java.sql.Time;
import java.util.Date;

public class Task {
    private int id;
    private String validity;
    private Date createdAt;
    private int campaignId;
    private int clientId;
    private int period;
    private String plan;
    private int userId;
    private Date dueDate;
    private Time estimatedTime;
    private Date managementDate;
    private int managementType;
    private int resultTypeId;
    private int anomalyTypeId;
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
    private boolean dataphonePaymer;
    private int latitude;
    private int longitude;

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Time getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Time estimatedTime) {
        this.estimatedTime = estimatedTime;
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

    public boolean isDataphonePaymer() {
        return dataphonePaymer;
    }

    public void setDataphonePaymer(boolean dataphonePaymer) {
        this.dataphonePaymer = dataphonePaymer;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
