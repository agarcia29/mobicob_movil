package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.ManagementTypeDao;
import com.mobicob.mobile.app.db.entity.ManagementType;

import java.util.List;

public class ManagementTypeRepository {

    private ManagementTypeDao mManagementTypeDao;
    private MutableLiveData<List<ManagementType>> mAllManagementType;
    private Observer<List<ManagementType>> managementTypeObserver;
    private boolean needManagementsFromWS = false;
    public ParamsRespository paramsRepo;

    public ManagementTypeRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        paramsRepo = new ParamsRespository(application);

        mManagementTypeDao = db.managementTypeDao();
        mAllManagementType = new MutableLiveData<List<ManagementType>>();
        managementTypeObserver =  new ManagementTypeObserver(application.getApplicationContext());
        mManagementTypeDao.getAllManagementTypes().observeForever(managementTypeObserver);
    }

    public LiveData<List<ManagementType>> getmManagementType() {
        return mAllManagementType;
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

    private class ManagementTypeObserver implements Observer<List<ManagementType>>{
        private Context context;

        public ManagementTypeObserver(Context context){
            this.context = context;
        }
        @Override
        public void onChanged(@Nullable final List<ManagementType> managementTypes) {
            if(managementTypes==null || managementTypes.isEmpty()) {
                needManagementsFromWS = true;
                paramsRepo.getParamsFromWS(context);
            }
            else{
                needManagementsFromWS = false;
                mAllManagementType.setValue(managementTypes);
            }
        }
    }
}
