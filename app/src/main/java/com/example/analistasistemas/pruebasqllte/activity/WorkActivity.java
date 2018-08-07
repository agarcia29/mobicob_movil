package com.example.analistasistemas.pruebasqllte.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.analistasistemas.pruebasqllte.R;
import com.example.analistasistemas.pruebasqllte.data.prefs.SessionPrefs;

public class WorkActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {

        // Redirección al Login
        if (!SessionPrefs.get(this).isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        super.onCreate(savedInstanceState);
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
}
