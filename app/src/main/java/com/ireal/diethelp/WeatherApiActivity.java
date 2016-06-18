package com.ireal.diethelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WeatherApiActivity extends AppCompatActivity {

    TextView cityField, currentTemperatureField,messageField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_api);


        final Button getWeather = (Button) findViewById(R.id.get_weather_button);

        cityField = (TextView)findViewById(R.id.city_field);
        messageField = (TextView)findViewById(R.id.weather_message);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);


        final WeatherApi.placeIdTask asyncTask = new WeatherApi.placeIdTask(new WeatherApi.AsyncResponse() {
            public void processFinish(String weather_city, String weather_temperature) {
                cityField.setText(weather_city);
                currentTemperatureField.setText(weather_temperature);
                if (Float.parseFloat(weather_temperature.substring(0, weather_temperature.length()-1) ) > 15){
                    messageField.setText("Pogoda sprzyja aktywności na dworzu.");
                }else{
                    messageField.setText("Pogoda nie sprzyja aktywności na dworzu.");
                }

            }
        });

        getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView cityActivityTextView = (TextView) findViewById(R.id.city_text);
                final WeatherApi.placeIdTask asyncTask = new WeatherApi.placeIdTask(new WeatherApi.AsyncResponse() {
                    public void processFinish(String weather_city, String weather_temperature) {
                        cityField.setText(weather_city);
                        currentTemperatureField.setText(weather_temperature);
                        if (Float.parseFloat(weather_temperature.substring(0, weather_temperature.length()-1) ) > 15){
                            messageField.setText("Pogoda sprzyja aktywności na dworzu.");
                        }else{
                            messageField.setText("Pogoda nie sprzyja aktywności na dworzu.");
                        }

                    }
                });

                String editTextValue = cityActivityTextView.getText().toString();
                asyncTask.execute(editTextValue);
            }
        });
       asyncTask.execute("Gdansk"); //

    }
}
