package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.ResultTypeDao;
import com.mobicob.mobile.app.db.entity.ResultType;

import java.util.List;

public class ResultTypeRepository {

    private ResultTypeDao mResultTypeDao;
    private LiveData<List<ResultType>> mAllResultTypes;

    public ResultTypeRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mResultTypeDao = db.resultTypeDao();
        mAllResultTypes = mResultTypeDao.getAllResultTypes();
    }

    public LiveData<List<ResultType>> getAllResultTypes() {
        return mAllResultTypes;
    }

    public LiveData<List<ResultType>> getByMangementType(int managementId){
        return mResultTypeDao.getByMangementType(managementId);
    }


    public void insert (ResultType resultType) {
        new InsertAsyncTask(mResultTypeDao).execute(resultType);
    }

    private static class InsertAsyncTask extends AsyncTask<ResultType, Void, Void> {

        private ResultTypeDao mAsyncTaskDao;

        InsertAsyncTask(ResultTypeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ResultType... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
