package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.DelegationDao;
import com.mobicob.mobile.app.db.entity.Delegation;

import java.util.List;

public class DelegationRepository {

    private DelegationDao mDelegationDao;
    private LiveData<List<Delegation>> mAllDelegations;

    public DelegationRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mDelegationDao = db.delegationDao();
        mAllDelegations = mDelegationDao.getAllDelegations();
    }

    public LiveData<List<Delegation>> getAllDelegations() {
        return mAllDelegations;
    }


    public void insert (Delegation delegation) {
        new InsertAsyncTask(mDelegationDao).execute(delegation);
    }

    private static class InsertAsyncTask extends AsyncTask<Delegation, Void, Void> {

        private DelegationDao mAsyncTaskDao;

        InsertAsyncTask(DelegationDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Delegation... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
