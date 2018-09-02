package com.mobicob.mobile.app.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.ui.adapter.ClientAdapter;
import com.mobicob.mobile.app.session.Preferences;
import com.mobicob.mobile.app.apiclient.JsonKeys;

import java.util.ArrayList;
import java.util.List;

public class ClientDataActivity extends Activity implements View.OnClickListener{
    private RecyclerView mRecyclerView;
    private ClientAdapter mAdapter;

    private Task mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_client);

            Button editGestionButton = (Button) findViewById(R.id.editGestionButton);
            editGestionButton.setOnClickListener(this);

            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewAssignments);
            mRecyclerView.setHasFixedSize(true);

            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new ClientAdapter(this);
            mRecyclerView.setAdapter(mAdapter);

            Bundle extra = getIntent().getExtras();
            mTask = (Task) extra.get(JsonKeys.TASK);
            List<Task> taskList = new ArrayList<>();
            taskList.add(mTask);
            mAdapter.setDataSet(taskList);
        }
        catch(Exception e)
        {
            Log.e("MOBICOB", e.getMessage(), e);
            showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class );
        intent.putExtra(JsonKeys.TASK, mTask);
        startActivity(intent);
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

    private void showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}