package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.ManagementType;

import java.util.List;

@Dao
public interface ManagementTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ManagementType... managementType);

    @Query("DELETE FROM ManagementType")
    void deleteAll();

    @Query("SELECT * from ManagementType ORDER BY id ASC")
    LiveData<List<ManagementType>> getAllManagementTypes();

    @Update
    public void updateManagementTypes(ManagementType... managementTypes);

    @Delete
    public void deleteManagementTypes(ManagementType... managementTypes);

    @Query("SELECT * FROM managementType WHERE id = :id")
    public LiveData<List<ManagementType>> getManagementTypeById(int id);

}
