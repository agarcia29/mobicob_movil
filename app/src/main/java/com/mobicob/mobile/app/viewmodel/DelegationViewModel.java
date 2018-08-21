package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.Delegation;
import com.mobicob.mobile.app.repository.DelegationRepository;

import java.util.List;

public class DelegationViewModel extends AndroidViewModel {

    private DelegationRepository mRepository;

    private LiveData<List<Delegation>> mAllDelegations;

    public DelegationViewModel(Application application) {
        super(application);
        mRepository = new DelegationRepository(application);
        mAllDelegations = mRepository.getAllDelegations();
    }

    LiveData<List<Delegation>> getAllDelegations() { return mAllDelegations; }

    public void insert(Delegation delegation) { mRepository.insert(delegation); }
}