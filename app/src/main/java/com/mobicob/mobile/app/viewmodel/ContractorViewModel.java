package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.Contractor;
import com.mobicob.mobile.app.repository.ContractorRepository;

import java.util.List;

public class ContractorViewModel extends AndroidViewModel {

    private ContractorRepository mRepository;

    private LiveData<List<Contractor>> mAllContractors;

    public ContractorViewModel(Application application) {
        super(application);
        mRepository = new ContractorRepository(application);
        mAllContractors = mRepository.getAllContractors();
    }

    LiveData<List<Contractor>> getAllContractors() { return mAllContractors; }

    public void insert(Contractor contractor) { mRepository.insert(contractor); }
}