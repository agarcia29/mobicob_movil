package com.mobicob.mobile.app.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Task extends ArrayList<Task> implements Serializable {
    private int id;
    private int period;
    private String validity;
    private String plan;
    private int userId;
    private Date dueDate;
    private Date createdAt;
    private Date updateAt;
    private Time estimatedTime;
    private Campaign campaign;
    private Client client;
    private User user;
    private Date managementDate;
    private int managementTypeId;
    private int resultTypeId;
    private int anomalyTypeId;
    private String collectionEntity;
    private Date paymentDate;
    private Date commitmentDate;
    private boolean personalContact;
    private int Idnumber;
    private String paymentHolder;
    private String phone;
    private String email;
    private String observations;
    private int readingSignature;
    private boolean dataphonePayment;
    private int latitude;
    private int longitude;
    private Time usedTime;


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

       public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getManagementDate() {
        return managementDate;
    }

    public void setManagementDate(Date managementDate) {
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

    public boolean isDataphonePayment() {
        return dataphonePayment;
    }

    public void setDataphonePayment(boolean dataphonePayment) {
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

    public Time getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Time usedTime) {
        this.usedTime = usedTime;
    }
}
