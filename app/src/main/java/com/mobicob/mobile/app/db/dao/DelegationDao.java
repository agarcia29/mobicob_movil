package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.Delegation;

import java.util.List;

@Dao
public interface DelegationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Delegation delegation);

    @Query("DELETE FROM Delegation")
    void deleteAll();

    @Query("SELECT * from Delegation ORDER BY id ASC")
    LiveData<List<Delegation>> getAllDelegations();

    @Update
    public void updateDelegations(Delegation... delegations);

    @Delete
    public void deleteDelegations(Delegation... delegations);

    @Query("SELECT * FROM delegation WHERE id = :id")
    public LiveData<List<Delegation>> getDelegationById(int id);

}
