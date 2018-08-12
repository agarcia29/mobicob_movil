package com.mobicob.mobile.app.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.adapters.TasksAdapter;
import com.mobicob.mobile.app.data.prefs.SessionPrefs;
import com.mobicob.mobile.app.model.TasksResponse;
import com.mobicob.mobile.app.restApi.network.RetrofitInstance;
import com.mobicob.mobile.app.restApi.services.MobicobApiServices;
import com.mobicob.mobile.app.wrappers.TaskResponseWrapper;

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

            mAdapter = new TasksAdapter();
            mRecyclerView.setAdapter(mAdapter);

          //  Gson gsonTasks = RetrofitInstance.buildTasksGson();
            MobicobApiServices api = RetrofitInstance.getApiServices(MainActivity.this, null);
            Call<TaskResponseWrapper> call = api.tasks(SessionPrefs.getToken(MainActivity.this));
            call.enqueue(new Callback<TaskResponseWrapper>() {
                @Override
                public void onResponse(Call<TaskResponseWrapper> call, Response<TaskResponseWrapper> response) {
                    if (response.isSuccessful()) {
                        TasksResponse tasklist = response.body().getData();
                        mAdapter.setDataSet(tasklist);
                    }
                }

                @Override
                public void onFailure(Call<TaskResponseWrapper> call, Throwable t) {
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onResponse(Call<TasksResponse> call, Response<TasksResponse> response) {

    }

    @Override
    public void onFailure(Call<TasksResponse> call, Throwable t) {

    }
}

