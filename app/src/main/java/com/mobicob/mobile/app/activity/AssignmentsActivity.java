package com.mobicob.mobile.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.adapters.TasksAdapter;
import com.mobicob.mobile.app.restApi.network.RetrofitInstance;
import com.mobicob.mobile.app.model.PendingClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssignmentsActivity extends Activity {
    private RecyclerView mRecyclerView;
    private TasksAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);


       /** mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssignments);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new TasksAdapter();
        mRecyclerView.setAdapter(mAdapter);

        Call<ArrayList<PendingClient>> call = RetrofitInstance.getApiServices(AssignmentsActivity.this).getPendClient();
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

    }

    // ...
        }*/
    }
}