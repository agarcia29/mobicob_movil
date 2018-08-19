package com.mobicob.mobile.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.ui.adapter.TasksAdapter;
import com.mobicob.mobile.app.session.Preferences;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.apiclient.network.RetrofitInstance;
import com.mobicob.mobile.app.apiclient.services.MobicobApiServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<TasksResponse> {
    private RecyclerView mRecyclerView;
    private TasksAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tasks);

            RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssignments);
            mRecyclerView.setHasFixedSize(true);

            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new TasksAdapter(this);
            mRecyclerView.setAdapter(mAdapter);

          //  Gson gsonTasks = RetrofitInstance.buildTasksGson();
            MobicobApiServices api = RetrofitInstance.getApiServicesTask(MainActivity.this);
            Call<TasksResponse> call = api.tasks(Preferences.getToken(MainActivity.this));
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
                    Toast.makeText(MainActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch(Exception e)
        {
            Log.e("MOBICOB", e.getMessage(), e);
        }
    }

    /** Method to generate List of notice using RecyclerView with custom adapter*/

    /** Method to generate List of notice using RecyclerView with custom adapter*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_logOut:
                //metodoAdd()
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

    }
}

