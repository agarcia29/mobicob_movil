package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.Contractor;

import java.util.List;

@Dao
public interface ContractorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Contractor contractor);

    @Query("DELETE FROM Contractor")
    void deleteAll();

    @Query("SELECT * from Contractor ORDER BY id ASC")
    LiveData<List<Contractor>> getAllContractors();

    @Update
    public void updateContractors(Contractor... contractors);

    @Delete
    public void deleteContractors(Contractor... contractors);

    @Query("SELECT * FROM contractor WHERE id = :id")
    public LiveData<List<Contractor>> getContractorById(int id);

}
