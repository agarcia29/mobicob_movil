package com.mobicob.mobile.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.adapters.ClientAdapter;
import com.mobicob.mobile.app.data.prefs.SessionPrefs;
import com.mobicob.mobile.app.model.Task;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.restApi.network.RetrofitInstance;
import com.mobicob.mobile.app.restApi.services.MobicobApiServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssignmentsActivity extends Activity {
    private RecyclerView mRecyclerView;
    private ClientAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssignments);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new ClientAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        Intent intent = getIntent();
        int taskId = intent.getIntExtra("task_id", 0);

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_client);

            RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssignments);
            mRecyclerView.setHasFixedSize(true);

            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new ClientAdapter(this);
            mRecyclerView.setAdapter(mAdapter);

            //  Gson gsonTasks = RetrofitInstance.buildTasksGson();
            MobicobApiServices api = RetrofitInstance.getApiServicesTask(AssignmentsActivity.this);
            Call<TasksResponse> call = api.tasks(SessionPrefs.getToken(AssignmentsActivity.this));
            call.enqueue(new Callback<TasksResponse>() {
                @Override
                public void onResponse(Call<TasksResponse> call, Response<TasksResponse> response) {
                    if (response.isSuccessful()) {
                        TasksResponse tasklist = response.body();
                        mAdapter.setDataSet(tasklist);
                    }
                }

                @Override
                public void onFailure(Call<TasksResponse> call, Throwable t) {
                    Log.e("MOBICOB", t.getMessage(), t);
                    Toast.makeText(AssignmentsActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch(Exception e)
        {
            Log.e("MOBICOB", e.getMessage(), e);
        }
    }

    }
