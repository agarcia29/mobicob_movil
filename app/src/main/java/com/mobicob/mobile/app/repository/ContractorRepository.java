package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.ContractorDao;
import com.mobicob.mobile.app.db.entity.Contractor;

import java.util.List;

public class ContractorRepository {

    private ContractorDao mContractorDao;
    private LiveData<List<Contractor>> mAllContractors;

    public ContractorRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mContractorDao = db.contractorDao();
        mAllContractors = mContractorDao.getAllContractors();
    }

    public LiveData<List<Contractor>> getAllContractors() {
        return mAllContractors;
    }


    public void insert (Contractor contractor) {
        new InsertAsyncTask(mContractorDao).execute(contractor);
    }

    private static class InsertAsyncTask extends AsyncTask<Contractor, Void, Void> {

        private ContractorDao mAsyncTaskDao;

        InsertAsyncTask(ContractorDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Contractor... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
