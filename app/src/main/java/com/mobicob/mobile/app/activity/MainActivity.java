package com.mobicob.mobile.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.adapters.TasksAdapter;
import com.mobicob.mobile.app.data.prefs.SessionPrefs;
import com.mobicob.mobile.app.network.RetrofitInstance;
import com.mobicob.mobile.app.model.Task;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Task>> {
    private RecyclerView mRecyclerView;
    private TasksAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewAssignments);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new TasksAdapter();
        mRecyclerView.setAdapter(mAdapter);
        Call<ArrayList<Task>> call = RetrofitInstance.getApiServices(MainActivity.this).
                getAssigment("Bearer "+SessionPrefs.getToken(MainActivity.this));
        call.enqueue(this);

    }
    @Override
    public void onResponse(Call<ArrayList<Task>> call, Response<ArrayList<Task>> response) {
        showScreen();

        }




    @Override
    public void onFailure(Call<ArrayList<Task>> call, Throwable t) {

    }
    private void showScreen() {
        Intent intent = new Intent(MainActivity.this,WorkActivity.class);
        startActivity(intent);
    }

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



}

