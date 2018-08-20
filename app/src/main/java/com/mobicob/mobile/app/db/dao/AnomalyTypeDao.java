package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.AnomalyType;

import java.util.List;

@Dao
public interface AnomalyTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AnomalyType anomalyType);

    @Query("DELETE FROM AnomalyType")
    void deleteAll();

    @Query("SELECT * from AnomalyType ORDER BY id ASC")
    LiveData<List<AnomalyType>> getAllAnomalyTypes();

    @Update
    public void updateAnomalyTypes(AnomalyType... anomalyTypes);

    @Delete
    public void deleteAnomalyTypes(AnomalyType... anomalyTypes);

    @Query("SELECT * FROM anomalyType WHERE id = :id")
    public LiveData<List<AnomalyType>> getAnomalyTypeById(int id);

}
