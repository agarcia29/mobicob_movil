package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.os.AsyncTask;
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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParamsRespository {
    private ManagementTypeDao mManagementTypeDao;
    private ResultTypeDao mResultTypeDao;
    private AnomalyTypeDao mAnomalyTypeDao;
    private Preferences sesionPreferences;

    public ParamsRespository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        sesionPreferences = Preferences.get(application);

        mManagementTypeDao = db.managementTypeDao();
        mResultTypeDao = db.resultTypeDao();
        mAnomalyTypeDao = db.anomalyTypeDao();
    }

    public void getParamsFromWS(){
        MobicobApiServices api = RetrofitInstance.getApiServicesParams();
        Call<ParamsResponse> call = api.params(sesionPreferences.getToken());
        call.enqueue(new Callback<ParamsResponse>() {
            @Override
            public void onResponse(Call<ParamsResponse> call, Response<ParamsResponse> response) {
                if (response.isSuccessful()) {
                    sesionPreferences.paramsDownloaded();
                    ParamsResponse paramsResponse = response.body();

                    if(!paramsResponse.getManagementType().isEmpty()){
                        insertManagementType(paramsResponse.getManagementType());
                    }
                    if(!paramsResponse.getResultType().isEmpty()){
                        insertResultType(paramsResponse.getResultType());
                    }
                    if(!paramsResponse.getAnomalyType().isEmpty()){
                        insertAnomalyType(paramsResponse.getAnomalyType());
                    }
                }
            }

            @Override
            public void onFailure(Call<ParamsResponse> call, Throwable t) {
                Log.e("MOBICOB", t.getMessage(), t);
            }
        });
    }

    public void insertManagementType (List<ManagementType> managementTypes) {
        ManagementType[] arrayManagementType = managementTypes.toArray(new ManagementType[managementTypes.size()]);
        new ParamsRespository.InsertAsyncMangementType(mManagementTypeDao).execute(arrayManagementType);
    }

    public void insertResultType (List<ResultType> resultTypes) {

        ResultType[] arrayResultType = resultTypes.toArray(new ResultType[resultTypes.size()]);
        new ParamsRespository.InsertAsyncResultType(mResultTypeDao).execute(arrayResultType);
    }

    public void insertAnomalyType (List<AnomalyType> anomalyTypes) {
        AnomalyType[] arrayAnomalyType = anomalyTypes.toArray(new AnomalyType[anomalyTypes.size()]);
        new ParamsRespository.InsertAsyncAnomalyType(mAnomalyTypeDao).execute(arrayAnomalyType);
    }


    private static class InsertAsyncMangementType extends AsyncTask<ManagementType, Void, Void> {

        private ManagementTypeDao mAsyncManagementDao;

        InsertAsyncMangementType(ManagementTypeDao dao) {
            mAsyncManagementDao = dao;
        }

        @Override
        protected Void doInBackground(final ManagementType... params) {
            mAsyncManagementDao.insert(params);
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
            mAsyncResultDao.insert(params);
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
            mAsyncAnomalyDao.insert(params);
            return null;
        }
    }
}
