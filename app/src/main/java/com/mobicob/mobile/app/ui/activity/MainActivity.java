package com.mobicob.mobile.app.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.apiclient.JsonKeys;
import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.ui.adapter.TasksAdapter;
import com.mobicob.mobile.app.session.Preferences;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.viewmodel.TaskViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<TasksResponse> {
    private TasksAdapter mAdapter;
    private TaskViewModel mTaskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tasks);

            RecyclerView mRecyclerView = findViewById(R.id.recyclerViewAssignments);
            mRecyclerView.setHasFixedSize(true);

            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new TasksAdapter(this);
            mRecyclerView.setAdapter(mAdapter);
            mTaskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
            mTaskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
                @Override
                public void onChanged(@Nullable final List<Task> tasks) {
                    mAdapter.setDataSet(tasks);
                }
            });
        }
        catch(Exception e)
        {
            Log.e("MOBICOB", e.getMessage(), e);
            showErrorMessage(e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_logOut:
                Preferences.get(this).sessionDestroy();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onResponse(Call<TasksResponse> call, Response<TasksResponse> response) {

    }

    @Override
    public void onFailure(Call<TasksResponse> call, Throwable t) {
        Log.e("MOBICOB", t.getMessage(), t);
        showErrorMessage(t.getMessage());
    }

    private void showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}