package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.Role;

import java.util.List;

@Dao
public interface RoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Role role);

    @Query("DELETE FROM Role")
    void deleteAll();

    @Query("SELECT * from Role ORDER BY id ASC")
    LiveData<List<Role>> getAllRoles();

    @Update
    public void updateRoles(Role... roles);

    @Delete
    public void deleteRoles(Role... roles);

    @Query("SELECT * FROM role WHERE id = :id")
    public LiveData<List<Role>> getRoleById(int id);

}
