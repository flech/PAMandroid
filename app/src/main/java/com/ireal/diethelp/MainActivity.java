package com.ireal.diethelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button productViewButton = (Button) findViewById(R.id.produkty_button);
        final Button dayViewButton = (Button) findViewById(R.id.days_button);
        final Button weatherApiButton = (Button) findViewById(R.id.weather_api_button);
        final Intent productViewActivityIntent = new Intent(this, ProductViewActivity.class);
        final Intent dayViewActivityIntent = new Intent(this, DayViewActivity.class);
        final Intent weatherApiActivityIntent = new Intent(this, WeatherApiActivity.class);

        productViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(productViewActivityIntent);
            }
        });

        dayViewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(dayViewActivityIntent);
            }
        });

        weatherApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(weatherApiActivityIntent);
            }
        });
    }
}
