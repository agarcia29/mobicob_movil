package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.repository.ResultTypeRepository;

import java.util.List;

public class ResultTypeViewModel extends AndroidViewModel {

    private ResultTypeRepository mRepository;

    private LiveData<List<ResultType>> mAllResultTypes;

    public ResultTypeViewModel(Application application) {
        super(application);
        mRepository = new ResultTypeRepository(application);
        mAllResultTypes = mRepository.getAllResultTypes();
    }

    LiveData<List<ResultType>> getAllResultTypes() { return mAllResultTypes; }

    public void insert(ResultType resultType) { mRepository.insert(resultType); }
}