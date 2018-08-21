package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.CampaignDao;
import com.mobicob.mobile.app.db.entity.Campaign;

import java.util.List;

public class CampaignRepository {

    private CampaignDao mCampaignDao;
    private LiveData<List<Campaign>> mAllCampaigns;

    public CampaignRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mCampaignDao = db.campaignDao();
        mAllCampaigns = mCampaignDao.getAllCampaigns();
    }

    public LiveData<List<Campaign>> getAllCampaigns() {
        return mAllCampaigns;
    }


    public void insert (Campaign campaign) {
        new InsertAsyncTask(mCampaignDao).execute(campaign);
    }

    private static class InsertAsyncTask extends AsyncTask<Campaign, Void, Void> {

        private CampaignDao mAsyncTaskDao;

        InsertAsyncTask(CampaignDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Campaign... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
