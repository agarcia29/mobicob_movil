package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.AnomalyTypeDao;
import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.session.Preferences;

import java.util.List;

public class AnomalyTypeRepository {

    private AnomalyTypeDao mAnomalyTypeDao;
    private LiveData<List<AnomalyType>> mAllAnomalyType;
    private ParamsRespository paramsRepo;
    private boolean needDownloadParams;

    public AnomalyTypeRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        needDownloadParams = Preferences.get(application).needDownloadParams();

        if(needDownloadParams){
            paramsRepo = new ParamsRespository(application);
            paramsRepo.getParamsFromWS();
        }
        mAnomalyTypeDao = db.anomalyTypeDao();
        mAllAnomalyType = mAnomalyTypeDao.getAllAnomalyTypes();
    }

    public LiveData<List<AnomalyType>> getmAllAnomalyType() {
        return mAllAnomalyType;
    }
}
