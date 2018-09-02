package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mRepository;

    private LiveData<List<Task>> mManagedTask;

    private LiveData<List<Task>> mPendingTask;

    private LiveData<List<Task>> mAllTasks;

    public TaskViewModel(Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mManagedTask = mRepository.getmManagedTask();
        mPendingTask = mRepository.getmPendingTask();
    }

    public LiveData<List<Task>> getmManagedTask() {
        return mManagedTask;
    }

    public LiveData<List<Task>> getmPendingTask() {
        return mPendingTask;
    }

    public void insert(Task task) { mRepository.insert(task); }

    public void insert(List<Task> tasks) { mRepository.insert(tasks); }
}