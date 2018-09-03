package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.repository.AnomalyTypeRepository;
import com.mobicob.mobile.app.repository.ParamsRespository;

import java.util.List;

public class AnomalyTypeViewModel extends AndroidViewModel {

    private ParamsRespository mRepository;

    private LiveData<List<AnomalyType>> mAllAnomalyTypes;

    public AnomalyTypeViewModel(Application application) {
        super(application);
        mRepository = new ParamsRespository(application);
        mAllAnomalyTypes = mRepository.getmAnomalyType();
    }

    public LiveData<List<AnomalyType>> getAllAnomalyTypes() { return mAllAnomalyTypes; }
    public LiveData<List<AnomalyType>> getByResultType(int resultId ){
        return mRepository.getByResultType(resultId);
    }

}