package com.mobicob.mobile.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.mobicob.mobile.app.R;
import com.mobicob.mobile.app.data.prefs.SessionPrefs;

public class WorkActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!SessionPrefs.get(this).isLoggedIn()) {
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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.assignedClientMenu:
                Intent intent = new Intent(this, MainActivity.class );
                startActivity(intent);
            break;
            case R.id.pendingClientMenu:
                break;
            case R.id.reportedManageMenu:
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
                SessionPrefs.get(this).sessionDestroy();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
