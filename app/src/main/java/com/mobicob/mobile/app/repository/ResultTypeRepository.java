package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.ResultTypeDao;
import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.session.Preferences;

import java.util.List;

public class ResultTypeRepository {

    private ResultTypeDao mResultTypeDao;
    private LiveData<List<ResultType>> mAllResultType;
    private ParamsRespository paramsRepo;
    private boolean needDownloadParams;

    public ResultTypeRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        needDownloadParams = Preferences.get(application).needDownloadParams();

        if(needDownloadParams){
            paramsRepo = new ParamsRespository(application);
            paramsRepo.getParamsFromWS();
        }
        mResultTypeDao = db.resultTypeDao();
        mAllResultType = mResultTypeDao.getAllResultTypes();
    }

    public LiveData<List<ResultType>> getmAllResultType() {
        return mAllResultType;
    }
}
