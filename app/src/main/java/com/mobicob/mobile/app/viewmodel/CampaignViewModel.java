package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.Campaign;
import com.mobicob.mobile.app.repository.CampaignRepository;

import java.util.List;

public class CampaignViewModel extends AndroidViewModel {

    private CampaignRepository mRepository;

    private LiveData<List<Campaign>> mAllCampaigns;

    public CampaignViewModel(Application application) {
        super(application);
        mRepository = new CampaignRepository(application);
        mAllCampaigns = mRepository.getAllCampaigns();
    }

    LiveData<List<Campaign>> getAllCampaigns() { return mAllCampaigns; }

    public void insert(Campaign campaign) { mRepository.insert(campaign); }
}