package com.mobicob.mobile.app.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository mRepository;

    private LiveData<Integer> mManagedTask;

    private LiveData<Integer> mPendingTask;

    private LiveData<List<Task>> mAllTasks;

    public TaskViewModel(Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTasks();
        mManagedTask = mRepository.countManagedTask();
        mPendingTask = mRepository.countPendingTask();
    }

    public LiveData<List<Task>> getAllTasks() { return mAllTasks; }

    public LiveData<Integer> countManagedTask(){return mManagedTask;}

    public LiveData<Integer> countPendingTask(){return mPendingTask;}

    public void insert(Task task) { mRepository.insert(task); }

    public void insert(List<Task> tasks) { mRepository.insert(tasks); }
}