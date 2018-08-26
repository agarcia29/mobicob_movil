package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(User user);

    @Query("DELETE FROM User")
    public void deleteAll();

    @Query("SELECT * from User ORDER BY user_id ASC")
    public LiveData<List<User>> getAllUsers();

    @Update
    public void updateUsers(User... users);

    @Delete
    public void deleteUsers(User... users);

    @Query("SELECT * FROM user WHERE user_id = :id")
    public LiveData<List<User>> getUserById(int id);

}
