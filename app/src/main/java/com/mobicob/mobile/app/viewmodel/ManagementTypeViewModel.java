package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.ManagementType;
import com.mobicob.mobile.app.repository.ManagementTypeRepository;

import java.util.List;

public class ManagementTypeViewModel extends AndroidViewModel {

    private ManagementTypeRepository mRepository;

    private LiveData<List<ManagementType>> mAllManagementTypes;

    public ManagementTypeViewModel(Application application) {
        super(application);
        mRepository = new ManagementTypeRepository(application);
        mAllManagementTypes = mRepository.getAllManagementTypes();
    }

    public LiveData<List<ManagementType>> getAllManagementTypes() { return mAllManagementTypes; }

    public void insert(ManagementType managementType) { mRepository.insert(managementType); }
}