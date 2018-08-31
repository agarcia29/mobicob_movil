package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task... tasks);

    @Query("DELETE FROM Task")
    void deleteAll();

    @Query("SELECT * from Task ORDER BY id ASC")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT COUNT(*) from Task where managementDate IS NULL ")
    public int countPendingTask();

    @Query("SELECT COUNT(*) from Task where managementDate IS NOT NULL")
    int countManagedTask();

    @Update
    public void updateTasks(Task... tasks);

    @Delete
    public void deleteTasks(Task... tasks);

    @Query("SELECT * FROM task WHERE id = :id")
    public LiveData<List<Task>> getTaskById(int id);

}
