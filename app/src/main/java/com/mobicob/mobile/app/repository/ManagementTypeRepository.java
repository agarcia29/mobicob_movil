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
import com.mobicob.mobile.app.session.Preferences;

import java.util.List;

public class ManagementTypeRepository {

    private ManagementTypeDao mManagementTypeDao;
    private LiveData<List<ManagementType>> mAllManagementType;
    private ParamsRespository paramsRepo;
    private boolean needDownloadParams;

    public ManagementTypeRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        needDownloadParams = Preferences.get(application).needDownloadParams();

        if(needDownloadParams){
            paramsRepo = new ParamsRespository(application);
            paramsRepo.getParamsFromWS();
        }
        mManagementTypeDao = db.managementTypeDao();
        mAllManagementType = mManagementTypeDao.getAllManagementTypes();
    }

    public LiveData<List<ManagementType>> getmAllManagementType() {
        return mAllManagementType;
    }
}
