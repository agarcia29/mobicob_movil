package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.AnomalyTypeDao;
import com.mobicob.mobile.app.db.entity.AnomalyType;

import java.util.List;

public class AnomalyTypeRepository {

    private AnomalyTypeDao mAnomalyTypeDao;
    private LiveData<List<AnomalyType>> mAllAnomalyTypes;

    public AnomalyTypeRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mAnomalyTypeDao = db.anomalyTypeDao();
        mAllAnomalyTypes = mAnomalyTypeDao.getAllAnomalyTypes();
    }

    public LiveData<List<AnomalyType>> getAllAnomalyTypes() {
        return mAllAnomalyTypes;
    }


    public void insert (AnomalyType anomalyType) {
        new InsertAsyncTask(mAnomalyTypeDao).execute(anomalyType);
    }

    private static class InsertAsyncTask extends AsyncTask<AnomalyType, Void, Void> {

        private AnomalyTypeDao mAsyncTaskDao;

        InsertAsyncTask(AnomalyTypeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final AnomalyType... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
