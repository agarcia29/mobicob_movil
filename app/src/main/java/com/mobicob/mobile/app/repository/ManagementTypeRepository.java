package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.ManagementTypeDao;
import com.mobicob.mobile.app.db.entity.ManagementType;

import java.util.List;

public class ManagementTypeRepository {

    private ManagementTypeDao mManagementTypeDao;
    private LiveData<List<ManagementType>> mAllManagementTypes;

    public ManagementTypeRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mManagementTypeDao = db.managementTypeDao();
        mAllManagementTypes = mManagementTypeDao.getAllManagementTypes();
    }

    public LiveData<List<ManagementType>> getAllManagementTypes() {
        return mAllManagementTypes;
    }


    public void insert (ManagementType managementType) {
        new InsertAsyncTask(mManagementTypeDao).execute(managementType);
    }

    private static class InsertAsyncTask extends AsyncTask<ManagementType, Void, Void> {

        private ManagementTypeDao mAsyncTaskDao;

        InsertAsyncTask(ManagementTypeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ManagementType... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
