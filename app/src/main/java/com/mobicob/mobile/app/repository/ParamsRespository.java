package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mobicob.mobile.app.apiclient.network.RetrofitInstance;
import com.mobicob.mobile.app.apiclient.services.MobicobApiServices;
import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.AnomalyTypeDao;
import com.mobicob.mobile.app.db.dao.ManagementTypeDao;
import com.mobicob.mobile.app.db.dao.ResultTypeDao;
import com.mobicob.mobile.app.db.entity.AnomalyType;
import com.mobicob.mobile.app.db.entity.ManagementType;
import com.mobicob.mobile.app.db.entity.ResultType;
import com.mobicob.mobile.app.model.ParamsResponse;
import com.mobicob.mobile.app.session.Preferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParamsRespository {
    private ManagementTypeDao mManagementTypeDao;
    private ResultTypeDao mResultTypeDao;
    private AnomalyTypeDao mAnomalyTypeDao;

    private MutableLiveData<List<ManagementType>> mAllManagementType;
    private MutableLiveData<List<ResultType>> mAllResultType;
    private MutableLiveData<List<AnomalyType>> mAllAnomalyType;

    private Observer<List<ManagementType>> managementTypeObserver;
    private Observer<List<ResultType>> resultTypeObserver;
    private Observer<List<AnomalyType>> anomalyTypeObserver;

    public ParamsRespository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);

        mManagementTypeDao = db.managementTypeDao();
        mResultTypeDao = db.resultTypeDao();
        mAnomalyTypeDao = db.anomalyTypeDao();

        mAllManagementType = new MutableLiveData<List<ManagementType>>();
        mAllResultType = new MutableLiveData<List<ResultType>>();
        mAllAnomalyType = new MutableLiveData<List<AnomalyType>>();

        managementTypeObserver =  new ManagementTypeObserver(application.getApplicationContext());
        resultTypeObserver =  new ResultTypeObserver(application.getApplicationContext());
        anomalyTypeObserver =  new AnomalyTypeObserver(application.getApplicationContext());

        mManagementTypeDao.getAllManagementTypes().observeForever(managementTypeObserver);
        mResultTypeDao.getAllResultTypes().observeForever(resultTypeObserver);
        mAnomalyTypeDao.getAllAnomalyTypes().observeForever(anomalyTypeObserver);
    }

    @Override
    protected void finalize() throws Throwable {
        //mTaskDao.getAllTasks().removeObserver(taskObserver);
        super.finalize();
    }

    public LiveData<List<ManagementType>> getmManagementType() {
        return mAllManagementType;
    }

    public LiveData<List<ResultType>> getmResultType() {
        return mAllResultType;
    }

    public LiveData<List<ResultType>> getByMangementType(int managementId){
        return mResultTypeDao.getByMangementType(managementId);
    }

    public LiveData<List<AnomalyType>> getmAnomalyType() {
        return mAllAnomalyType;
    }

    public LiveData<List<AnomalyType>> getByResultType(int resultId){
        return mAnomalyTypeDao.getByResultType(resultId);
    }

    public void getParamsFromWS(Context context){
        MobicobApiServices api = RetrofitInstance.getApiServicesParams();
        Call<ParamsResponse> call = api.params(Preferences.getToken(context));
        call.enqueue(new Callback<ParamsResponse>() {
            @Override
            public void onResponse(Call<ParamsResponse> call, Response<ParamsResponse> response) {
                if (response.isSuccessful()) {
                    ParamsResponse paramsResponse = response.body();
                    if(!paramsResponse.getManagementType().isEmpty() ||
                       !paramsResponse.getResultType().isEmpty() ||
                       !paramsResponse.getAnomalyType().isEmpty()) {

                            insert(paramsResponse.getManagementType(), paramsResponse.getResultType()
                                    , paramsResponse.getAnomalyType());
                    }
                }
            }

            @Override
            public void onFailure(Call<ParamsResponse> call, Throwable t) {
                Log.e("MOBICOB", t.getMessage(), t);
                mAllManagementType.setValue(new ArrayList<ManagementType>());
                mAllResultType.setValue(new ArrayList<ResultType>());
                mAllAnomalyType.setValue(new ArrayList<AnomalyType>());
            }
        });
    }


    public void insert (ManagementType managementType, ResultType resultType, AnomalyType anomalyType) {
        new ParamsRespository.InsertAsyncMangementType(mManagementTypeDao).execute(managementType);
        new ParamsRespository.InsertAsyncResultType(mResultTypeDao).execute(resultType);
        new ParamsRespository.InsertAsyncAnomalyType(mAnomalyTypeDao).execute(anomalyType);
    }

    private static class InsertAsyncMangementType extends AsyncTask<ManagementType, Void, Void> {

        private ManagementTypeDao mAsyncManagementDao;

        InsertAsyncMangementType(ManagementTypeDao dao) {
            mAsyncManagementDao = dao;
        }

        @Override
        protected Void doInBackground(final ManagementType... params) {
            mAsyncManagementDao.insert(params[0]);
            return null;
        }
    }

    private static class InsertAsyncResultType extends AsyncTask<ResultType, Void, Void> {

        private ResultTypeDao mAsyncResultDao;

        InsertAsyncResultType(ResultTypeDao dao) {
            mAsyncResultDao = dao;
        }

        @Override
        protected Void doInBackground(final ResultType... params) {
            mAsyncResultDao.insert(params[0]);
            return null;
        }
    }

    private static class InsertAsyncAnomalyType extends AsyncTask<AnomalyType, Void, Void> {

        private AnomalyTypeDao mAsyncAnomalyDao;

        InsertAsyncAnomalyType(AnomalyTypeDao dao) {
            mAsyncAnomalyDao = dao;
        }

        @Override
        protected Void doInBackground(final AnomalyType... params) {
            mAsyncAnomalyDao.insert(params[0]);
            return null;
        }
    }

    public void insert (List<ManagementType> managementTypes, List<ResultType> resultTypes
            ,List<AnomalyType> anomalyTypes  ) {
        ManagementType[] arrayManagementType = managementTypes.toArray(new ManagementType[0]);
        new ParamsRespository.InsertAsyncMangementType(mManagementTypeDao).execute(arrayManagementType);
        ResultType[] arrayResultType = resultTypes.toArray(new ResultType[0]);
        new ParamsRespository.InsertAsyncResultType(mResultTypeDao).execute(arrayResultType);
        AnomalyType[] arrayAnomalyType = anomalyTypes.toArray(new AnomalyType[0]);
        new ParamsRespository.InsertAsyncAnomalyType(mAnomalyTypeDao).execute(arrayAnomalyType);
    }

    public class ManagementTypeObserver implements Observer<List<ManagementType>>{
        private Context context;

        public ManagementTypeObserver(Context context){
            this.context = context;
        }
        @Override
        public void onChanged(@Nullable final List<ManagementType> managementTypes) {
            if(managementTypes==null || managementTypes.isEmpty()) {
                needManagementsFromWS = true;
                syncObserversBeforeCallWS(context);
            }
            else{
                needManagementsFromWS = false;
                mAllManagementType.setValue(managementTypes);
            }
        }
    }

    private class ResultTypeObserver implements Observer<List<ResultType>>{
        private Context context;

        public ResultTypeObserver(Context context){
            this.context = context;
        }
        @Override
        public void onChanged(@Nullable final List<ResultType> resultTypes) {
            if(resultTypes==null || resultTypes.isEmpty()) {
                needResultsFromWS = true;
                syncObserversBeforeCallWS(context);
            }
            else{
                needResultsFromWS = false;
                mAllResultType.setValue(resultTypes);
            }
        }
    }

    private class AnomalyTypeObserver implements Observer<List<AnomalyType>>{
        private Context context;

        public AnomalyTypeObserver(Context context){
            this.context = context;
        }
        @Override
        public void onChanged(@Nullable final List<AnomalyType> anomalytTypes) {
            if(anomalytTypes==null || anomalytTypes.isEmpty()) {
                needAnomaliesFromWS = true;
                syncObserversBeforeCallWS(context);
            }
            else{
                needAnomaliesFromWS = false;
                mAllAnomalyType.setValue(anomalytTypes);
            }
        }
    }

    private boolean needAnomaliesFromWS = false;
    private boolean needResultsFromWS = false;
    private boolean needManagementsFromWS = false;

    private void syncObserversBeforeCallWS(Context context){
        if(needAnomaliesFromWS && needResultsFromWS && needManagementsFromWS)
        {
            getParamsFromWS(context);
        }
    }
}
