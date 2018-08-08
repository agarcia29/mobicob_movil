package com.mobicob.mobile.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.adapters.AssignmentsAdapter;
import com.mobicob.mobile.app.network.RetrofitInstance;
import com.mobicob.mobile.app.model.Client;
import com.mobicob.mobile.app.model.PendingClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssignmentsActivity extends Activity {
    private RecyclerView mRecyclerView;
    private AssignmentsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssignments);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new AssignmentsAdapter();
        mRecyclerView.setAdapter(mAdapter);

        Call<ArrayList<PendingClient>> call = RetrofitInstance.getApiServices().getPendClient();
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ArrayList<PendingClient>>() {
            @Override
            public void onResponse(Call<ArrayList<PendingClient>> call, Response<ArrayList<PendingClient>> response) {
            }

            @Override
            public void onFailure(Call<ArrayList<PendingClient>> call, Throwable t) {
                Toast.makeText(AssignmentsActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void generatePendingClient(ArrayList<Client> pendingClientArrayList) {
        mRecyclerView = findViewById(R.id.recyclerViewAssignments);
        mAdapter = new AssignmentsAdapter(pendingClientArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AssignmentsActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    }

    // ...

