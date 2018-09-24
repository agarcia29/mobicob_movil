package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.ResultType;

import java.util.List;

@Dao
public interface ResultTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ResultType... resultType);

    @Query("DELETE FROM ResultType")
    void deleteAll();

    @Query("SELECT * from ResultType ORDER BY id ASC")
    LiveData<List<ResultType>> getAllResultTypes();

    @Update
    public void updateResultTypes(ResultType... resultTypes);

    @Delete
    public void deleteResultTypes(ResultType... resultTypes);

    @Query("SELECT * FROM resultType WHERE id = :id")
    public LiveData<List<ResultType>> getById(int id);

}
