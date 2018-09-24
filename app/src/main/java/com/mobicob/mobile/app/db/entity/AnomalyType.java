package com.mobicob.mobile.app.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;

@Entity
public class AnomalyType implements Serializable {
    
    @PrimaryKey
    @NonNull
    private int id;
    private String code;
    private String name;
    private String description;
    private String resultIds;

    public AnomalyType() {
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResultIds() {
        return resultIds;
    }

    public void setResultIds(String resultIds) {
        this.resultIds = resultIds;
    }

    public boolean belongsTo(int resultId){
        if (resultIds==null) return false;
        return Arrays.asList(resultIds.split(",")).contains(resultId+"");
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
