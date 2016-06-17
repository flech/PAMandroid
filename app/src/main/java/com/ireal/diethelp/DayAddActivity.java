package com.ireal.diethelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DayAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_add);
        final Button dayAddDbButton = (Button) findViewById(R.id.addDayDb_button);
        final DBHandler db = new DBHandler(this);
        final Intent dayViewActivityIntent = new Intent(this, DayViewActivity.class);


        dayAddDbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView nameTextView = (TextView) findViewById(R.id.nameDayTextView);
                final TextView kcalTextView = (TextView) findViewById(R.id.kcalDayTextView);

                final String nameTextValue = nameTextView.getText().toString();
                final String kcalTextValue = kcalTextView.getText().toString();

                db.addDay(new Day(nameTextValue, Integer.parseInt(kcalTextValue)));
                startActivity(dayViewActivityIntent);
            }
        });
    }
}
