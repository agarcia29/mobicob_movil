package com.mobicob.mobile.app.model;

import java.util.Date;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Date creation;
    private int idNumber;
    private Contractor contractorId;
    private Role roleId;
    private String phone;
    private String address;
    private boolean active;
    private String latitude;
    private String longitude;
    private Delegation delegationId;
    private String position;
    private String token;

    public User(){

    }

    public User(int id, String username, String email, String name, String lastname, Date creation,
                int idNumber, Contractor contractorId, Role roleId, String phone, String address,
                boolean active, String latitude, String longitude, Delegation delegationId,
                String position) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.creation = creation;
        this.idNumber = idNumber;
        this.contractorId = contractorId;
        this.roleId = roleId;
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.latitude = latitude;
        this.longitude = longitude;
        this.delegationId = delegationId;
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Contractor getContractorId() {
        return contractorId;
    }

    public void setContractorId(Contractor contractorId) {
        this.contractorId = contractorId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Delegation getDelegationId() {
        return delegationId;
    }

    public void setDelegationId(Delegation delegationId) {
        this.delegationId = delegationId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}