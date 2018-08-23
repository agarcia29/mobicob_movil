package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mobicob.mobile.app.apiclient.network.RetrofitInstance;
import com.mobicob.mobile.app.apiclient.services.MobicobApiServices;
import com.mobicob.mobile.app.db.MobicobDB;
import com.mobicob.mobile.app.db.dao.TaskDao;
import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.session.Preferences;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepository {

    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;
    private Context applicationContext;

    public TaskRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAllTasks();
        if(mAllTasks.getValue().isEmpty()){
            getTaskFromWS();
        }

        applicationContext = application.getApplicationContext();
    }

    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    private void getTaskFromWS(){
        MobicobApiServices api = RetrofitInstance.getApiServicesTask();
        Call<TasksResponse> call = api.tasks(Preferences.getToken(applicationContext));
        call.enqueue(new Callback<TasksResponse>() {
            @Override
            public void onResponse(Call<TasksResponse> call, Response<TasksResponse> response) {
                if (response.isSuccessful()) {
                    TasksResponse tasksResponse = response.body();
                    insert(tasksResponse.getTasks());
                    //mAllTasks.getValue().clear();
                    //mAllTasks.getValue().addAll(tasksResponse.getTasks());
                }
            }

            @Override
            public void onFailure(Call<TasksResponse> call, Throwable t) {
                Log.e("MOBICOB", t.getMessage(), t);
                mAllTasks.getValue().clear();
            }
        });
    }

    public void insert (Task task) {
        new InsertAsyncTask(mTaskDao).execute(task);
    }

    public void insert (List<Task> tasks) {
        Task[] arrayTasks = tasks.toArray(new Task[0]);
        new InsertAsyncTask(mTaskDao).execute(arrayTasks);
    }

    private static class InsertAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDao mAsyncTaskDao;

        InsertAsyncTask(TaskDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Task... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
