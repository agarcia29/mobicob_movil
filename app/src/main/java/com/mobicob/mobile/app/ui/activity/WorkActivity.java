package com.mobicob.mobile.app.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.db.entity.Task;
import com.mobicob.mobile.app.session.Preferences;
import com.mobicob.mobile.app.ui.adapter.TasksAdapter;
import com.mobicob.mobile.app.viewmodel.TaskViewModel;

import java.util.List;

public class WorkActivity extends AppCompatActivity implements View.OnClickListener {

    private TasksAdapter mAdapter;
    private TaskViewModel mTaskViewModel;
    private int countPendingTask = 0;
    private int countManagedTask = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!Preferences.get(this).isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.content_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.assignedClientMenu);
        linearLayout.setOnClickListener(this);

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.pendingClientMenu);
        linearLayout2.setOnClickListener(this);

        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.reportedManageMenu);
        linearLayout3.setOnClickListener(this);


       mTaskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);

        mTaskViewModel.getmPendingTask().observe(WorkActivity.this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> pendingTask) {
                countPendingTask = pendingTask.size();
                TextView txtNumPTask = (TextView) findViewById(R.id.NumClientP);
                txtNumPTask.setText(countPendingTask+"");

                TextView txtNumAllTask = (TextView) findViewById(R.id.NumClientA);
                txtNumAllTask.setText((countPendingTask+countManagedTask) + "");
            }
        });

        mTaskViewModel.getmManagedTask().observe(WorkActivity.this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> managedTask) {
                countManagedTask = managedTask.size();
                TextView txtNumMTask = (TextView) findViewById(R.id.NumClientGR);
                txtNumMTask.setText(countManagedTask+"");

                TextView txtNumAllTask = (TextView) findViewById(R.id.NumClientA);
                txtNumAllTask.setText((countPendingTask+countManagedTask) + "");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.assignedClientMenu:
            break;
            case R.id.pendingClientMenu:
                Intent intent = new Intent(this, TaskActivity.class );
                startActivity(intent);
                break;
            case R.id.reportedManageMenu:
                if(countManagedTask != 0) {
                    Intent intent2 = new Intent(this, ManagedTaskActivity.class);
                    startActivity(intent2);
                }else{
                    showErrorMessage("No existen tareas gestionadas");
                }
                break;
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

    private void showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
