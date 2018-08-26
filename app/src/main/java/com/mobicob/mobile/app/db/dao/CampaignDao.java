package com.mobicob.mobile.app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mobicob.mobile.app.db.entity.Campaign;

import java.util.List;

@Dao
public interface CampaignDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Campaign campaign);

    @Query("DELETE FROM Campaign")
    public void deleteAll();

    @Query("SELECT * from Campaign ORDER BY campaign_id ASC")
    public LiveData<List<Campaign>> getAllCampaigns();

    @Update
    public void updateCampaigns(Campaign... campaigns);

    @Delete
    public void deleteCampaigns(Campaign... campaigns);

    @Query("SELECT * FROM Campaign WHERE campaign_id = :id")
    public LiveData<List<Campaign>> getCampaignById(int id);

}
