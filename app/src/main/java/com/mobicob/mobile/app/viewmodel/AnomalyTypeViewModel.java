package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.repository.AnomalyTypeRepository;

import java.util.List;

public class AnomalyTypeViewModel extends AndroidViewModel {

    private AnomalyTypeRepository mAnomalyTypeRepository;

    private LiveData<List<AnomalyType>> mAllAnomalyTypes;

    public AnomalyTypeViewModel(Application application) {
        super(application);
        mAnomalyTypeRepository = new AnomalyTypeRepository(application);
        mAllAnomalyTypes = mAnomalyTypeRepository.getmAllAnomalyType();
    }

    public LiveData<List<AnomalyType>> getAllAnomalyTypes() { return mAllAnomalyTypes; }

}