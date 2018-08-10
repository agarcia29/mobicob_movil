package com.mobicob.mobile.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TasksClient {

    private String nic;
    private String address;
    private String neighborhood;
    private String municipality;
    private String corregimiento;
    private String department;


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipalty(String municipalty) {
        this.municipality = municipalty;
    }

    public String getCorregimiento() {
        return corregimiento;
    }

    public void setCorregimiento(String corregimiento) {
        this.corregimiento = corregimiento;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
