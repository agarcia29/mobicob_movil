package com.mobicob.mobile.app.model;

import java.sql.Time;
import java.util.Date;

public class Result {
    private int id;
    private Date updateAt;
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

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
