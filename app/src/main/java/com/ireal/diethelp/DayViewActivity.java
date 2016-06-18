package com.ireal.diethelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class DayViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);
        ListView listView = (ListView) findViewById(R.id.day_list_view);
        final Button dayAddButton = (Button) findViewById(R.id.addDay_button);
        final Intent dayAddActivityIntent = new Intent(this, DayAddActivity.class);
        final Intent dayDetailsActivityIntent = new Intent(this, DayDetailsActivity.class);
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
                pages[i] = day.getId() + " " +day.getName() + " Zaplanowane kalorie: " + day.getKcal();
                i++;}
        }
        
        dayAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(dayAddActivityIntent);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, pages);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dayDetailsActivityIntent.putExtra("address", pages[position].split(" ")[0]);
                startActivity(dayDetailsActivityIntent);
            }
        });
    }



}
