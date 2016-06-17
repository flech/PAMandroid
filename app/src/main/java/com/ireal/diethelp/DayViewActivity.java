package com.ireal.diethelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class DayViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);
        ListView listView = (ListView) findViewById(R.id.day_list_view);
        DBHandler db = new DBHandler(this);
        List<Day> days = db.getAllDays();
        for (Day day : days) {
            String log = "Id: " + day.getId() + " ,Name: " + day.getName();
            Log.d("Day: : ", log);
        }
        final String[] pages = new String[days.size()];
        int i= 0;
        for (Day day : days) {
            if(i <= days.size()){
                pages[i] = day.getName();
                i++;}
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, pages);

        listView.setAdapter(adapter);
    }



}
