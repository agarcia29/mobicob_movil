package com.mobicob.mobile.app.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Client {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "client_id")
    private int id;
    private int nic;
    private String unicom;
    private int delegation_id;
    private int nisRad;
    private String departament;
    private String municipality;
    private String corregimiento;
    private String neighborhood;
    private String streetType;
    private String streetName;
    private String duplicator;
    @ColumnInfo(name = "client_number")
    private int number;
    private String cgv;
    private String address;
    private String name;
    @ColumnInfo(name = "client_id_number")
    private int idNumber;
    @ColumnInfo(name = "client_phone")
    private String phone;
    private String rate;
    @ColumnInfo(name = "client_state")
    private String state;
    private int route;
    private int readingItinerary;
    private int aol;
    private String measurer;
    private String measurerType;
    private String measurerBrand;
    private int energyDebt;
    private int irregularDebt;
    private int thirdPartyDebt;
    private int financedDebt;
    private int overdueBills;
    private int agreedBills;
    @ColumnInfo(name = "client_created_at")
    private String createdAt;
    @ColumnInfo(name = "client_updated_at")
    private String updatedAt;

    public int getNic() {
        return nic;
    }

    public void setNic(int nic) {
        this.nic = nic;
    }

    public String getUnicom() {
        return unicom;
    }

    public void setUnicom(String unicom) {
        this.unicom = unicom;
    }

    public int getDelegation_id() {
        return delegation_id;
    }

    public void setDelegation_id(int delegation_id) {
        this.delegation_id = delegation_id;
    }

    public int getNisRad() {
        return nisRad;
    }

    public void setNisRad(int nisRad) {
        this.nisRad = nisRad;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCorregimiento() {
        return corregimiento;
    }

    public void setCorregimiento(String corregimiento) {
        this.corregimiento = corregimiento;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDuplicator() {
        return duplicator;
    }

    public void setDuplicator(String duplicator) {
        this.duplicator = duplicator;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCgv() {
        return cgv;
    }

    public void setCgv(String cgv) {
        this.cgv = cgv;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public int getReadingItinerary() {
        return readingItinerary;
    }

    public void setReadingItinerary(int readingItinerary) {
        this.readingItinerary = readingItinerary;
    }

    public int getAol() {
        return aol;
    }

    public void setAol(int aol) {
        this.aol = aol;
    }

    public String getMeasurer() {
        return measurer;
    }

    public void setMeasurer(String measurer) {
        this.measurer = measurer;
    }

    public String getMeasurerType() {
        return measurerType;
    }

    public void setMeasurerType(String measurerType) {
        this.measurerType = measurerType;
    }

    public String getMeasurerBrand() {
        return measurerBrand;
    }

    public void setMeasurerBrand(String measurerBrand) {
        this.measurerBrand = measurerBrand;
    }

    public int getEnergyDebt() {
        return energyDebt;
    }

    public void setEnergyDebt(int energyDebt) {
        this.energyDebt = energyDebt;
    }

    public int getIrregularDebt() {
        return irregularDebt;
    }

    public void setIrregularDebt(int irregularDebt) {
        this.irregularDebt = irregularDebt;
    }

    public int getThirdPartyDebt() {
        return thirdPartyDebt;
    }

    public void setThirdPartyDebt(int thirdPartyDebt) {
        this.thirdPartyDebt = thirdPartyDebt;
    }

    public int getFinancedDebt() {
        return financedDebt;
    }

    public void setFinancedDebt(int financedDebt) {
        this.financedDebt = financedDebt;
    }

    public int getOverdueBills() {
        return overdueBills;
    }

    public void setOverdueBills(int overdueBills) {
        this.overdueBills = overdueBills;
    }

    public int getAgreedBills() {
        return agreedBills;
    }

    public void setAgreedBills(int agreedBills) {
        this.agreedBills = agreedBills;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
