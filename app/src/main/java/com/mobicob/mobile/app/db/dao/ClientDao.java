package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.Client;

import java.util.List;

@Dao
public interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Client client);

    @Query("DELETE FROM Client")
    public void deleteAll();

    @Query("SELECT * from Client ORDER BY client_id ASC")
    public LiveData<List<Client>> getAllClients();

    @Update
    public void updateClients(Client... clients);

    @Delete
    public void deleteClients(Client... clients);

    @Query("SELECT * FROM client WHERE client_id = :id")
    public LiveData<List<Client>> getClientById(int id);

}
