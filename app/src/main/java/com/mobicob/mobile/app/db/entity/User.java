package com.mobicob.mobile.app.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_id")
    private int id;

    @ColumnInfo(name = "user_username")
    private String username;

    @ColumnInfo(name = "user_email")
    private String email;

    @ColumnInfo(name = "user_password")
    private String password;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_lastName")
    private String lastName;

    @ColumnInfo(name = "user_creation")
    private String creation;

    @ColumnInfo(name = "user_id_number")
    private int idNumber;

    @ColumnInfo(name = "user_phone")
    private String phone;

    @ColumnInfo(name = "user_address")
    private String address;

    @ColumnInfo(name = "user_active")
    private boolean active;

    @ColumnInfo(name = "user_latitude")
    private String latitude;

    @ColumnInfo(name = "user_longitude")
    private String longitude;

    @ColumnInfo(name = "user_position")
    private String position;

    public User(){

    }

    @Ignore
    public User(int id, String username, String email, String name, String lastName, String creation,
                int idNumber, String phone, String address,
                boolean active, String latitude, String longitude, String position) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.creation = creation;
        this.idNumber = idNumber;
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}