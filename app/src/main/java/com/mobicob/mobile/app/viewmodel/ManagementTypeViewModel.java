package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.ManagementType;
import com.mobicob.mobile.app.repository.ManagementTypeRepository;
import com.mobicob.mobile.app.repository.ParamsRespository;

import java.util.List;

public class ManagementTypeViewModel extends AndroidViewModel {

    private ParamsRespository mRepository;

    private LiveData<List<ManagementType>> mAllManagementTypes;

    public ManagementTypeViewModel(Application application) {
        super(application);
        mRepository = new ParamsRespository(application);
        mAllManagementTypes = mRepository.getmManagementType();
    }

    public LiveData<List<ManagementType>> getAllManagementTypes() { return mAllManagementTypes; }

}