package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.repository.AnomalyTypeRepository;

import java.util.List;

public class AnomalyTypeViewModel extends AndroidViewModel {

    private AnomalyTypeRepository mRepository;

    private LiveData<List<AnomalyType>> mAllAnomalyTypes;

    public AnomalyTypeViewModel(Application application) {
        super(application);
        mRepository = new AnomalyTypeRepository(application);
        mAllAnomalyTypes = mRepository.getAllAnomalyTypes();
    }

    public LiveData<List<AnomalyType>> getAllAnomalyTypes() { return mAllAnomalyTypes; }

    public void insert(AnomalyType anomalyType) { mRepository.insert(anomalyType); }
}