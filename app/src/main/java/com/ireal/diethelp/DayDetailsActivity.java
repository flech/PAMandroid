package com.ireal.diethelp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DayDetailsActivity extends AppCompatActivity {
    TextView dayName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_details);
        dayName = (TextView)findViewById(R.id.dayNameTextView);
        String name = getIntent().getStringExtra("address");
        dayName.setText(name);
    }

}
