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
        final Button weatherApiButton = (Button) findViewById(R.id.weather_api_button);
        final Intent productViewActivityIntent = new Intent(this, ProductViewActivity.class);
        final Intent weatherApiActivityIntent = new Intent(this, WeatherApiActivity.class);

        productViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(productViewActivityIntent);
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
