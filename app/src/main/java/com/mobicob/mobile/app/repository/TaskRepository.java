package com.mobicob.mobile.app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
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
    private Observer<List<Task>> taskObserver;

    public TaskRepository(Application application) {
        MobicobDB db = MobicobDB.getDatabase(application);
        mTaskDao = db.taskDao();
        taskObserver =  new TaskObserver(application.getApplicationContext());
        mTaskDao.getAllTasks().observeForever(taskObserver);
    }

    @Override
    protected void finalize() throws Throwable {
        mTaskDao.getAllTasks().removeObserver(taskObserver);
        super.finalize();
    }

    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    private void getTaskFromWS(Context context){
        MobicobApiServices api = RetrofitInstance.getApiServicesTask();
        Call<TasksResponse> call = api.tasks(Preferences.getToken(context));
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

    private class TaskObserver implements Observer<List<Task>>{

        Context context;

        public TaskObserver(Context context){
            this.context = context;
        }

        @Override
        public void onChanged(@Nullable final List<Task> tasks) {
            if(tasks==null || tasks.isEmpty()) {
                getTaskFromWS(context);
            }
            else{
                mAllTasks.getValue().clear();
                mAllTasks.getValue().addAll(tasks);
            }
        }
    }
}
