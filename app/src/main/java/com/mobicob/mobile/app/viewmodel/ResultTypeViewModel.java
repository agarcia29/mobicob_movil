package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.repository.ResultTypeRepository;
import com.mobicob.mobile.app.ui.activity.ResultActivity;

import java.util.List;
import java.util.stream.Collectors;

public class ResultTypeViewModel extends AndroidViewModel {

    private ResultTypeRepository mResultTypeRepository;

    private LiveData<List<ResultType>> mAllResultTypes;

    public ResultTypeViewModel(Application application) {
        super(application);
        mResultTypeRepository = new ResultTypeRepository(application);
        mAllResultTypes = mResultTypeRepository.getmAllResultType();
    }

    public LiveData<List<ResultType>> getAllResultTypes() { return mAllResultTypes; }
}