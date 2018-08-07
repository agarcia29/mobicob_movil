package com.example.analistasistemas.pruebasqllte;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.analistasistemas.pruebasqllte.adapters.AssignmentsAdapter;
import com.example.analistasistemas.pruebasqllte.adapters.MobicobApiAdapter;
import com.example.analistasistemas.pruebasqllte.model.Tasks;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Tasks>> {

    private AssignmentsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewAssignments);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AssignmentsAdapter();
        mRecyclerView.setAdapter(mAdapter);
        Call<ArrayList<Tasks>> call = MobicobApiAdapter.getApiServices().getAssigment();
        call.enqueue(this);

    }
    @Override
    public void onResponse(Call<ArrayList<Tasks>> call, Response<ArrayList<Tasks>> response) {

        }


    @Override
    public void onFailure(Call<ArrayList<Tasks>> call, Throwable t) {

    }


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

