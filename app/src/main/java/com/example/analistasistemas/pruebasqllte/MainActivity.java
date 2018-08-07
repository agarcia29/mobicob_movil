package com.example.analistasistemas.pruebasqllte;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.analistasistemas.pruebasqllte.adapters.AssignmentsAdapter;
import com.example.analistasistemas.pruebasqllte.adapters.MobicobApiAdapter;
import com.example.analistasistemas.pruebasqllte.data.prefs.SessionPrefs;
import com.example.analistasistemas.pruebasqllte.model.Assignment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.loopj.android.http.AsyncHttpClient.log;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Assignment>> {

    private AssignmentsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Redirección al Login
        if (!SessionPrefs.get(this).isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewAssignments);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AssignmentsAdapter();
        mRecyclerView.setAdapter(mAdapter);
        Call<ArrayList<Assignment>> call = MobicobApiAdapter.getApiServices().getAssigment();
        call.enqueue(this);

    }
    @Override
    public void onResponse(Call<ArrayList<Assignment>> call, Response<ArrayList<Assignment>> response) {

        }


    @Override
    public void onFailure(Call<ArrayList<Assignment>> call, Throwable t) {

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

