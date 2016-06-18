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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DayAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_add);
        final Button dayAddDbButton = (Button) findViewById(R.id.addDayDb_button);
        final DBHandler db = new DBHandler(this);
        final Intent dayViewActivityIntent = new Intent(this, DayViewActivity.class);
        ListView listView = (ListView) findViewById(R.id.product_list_view);
        final List<Integer> prod_ids = new ArrayList<Integer>();
        List<Product> products = db.getAllProducts();
        final List<Day> days = db.getAllDays();

        for (Product product : products) {
            String log = product.getId() + " ,Name: " + product.getName() + " ,WHEY: " + product.getWhey();
            Log.d("Product: : ", log);
        }
        final String[] pages = new String[products.size()];
        int i= 0;
        for (Product product : products) {
            if(i <= products.size()){
                pages[i] =product.getId() + " " + product.getName() + " Białko: " + product.getWhey() + " Węglowodany: " + product.getCarb() + " Tłuszcz: " + product.getFat();
                i++;}
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, pages);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String item = ((TextView)view).getText().toString();
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                prod_ids.add(Integer.parseInt(item.split(" ")[0]));
                String log = "Id: " + Integer.parseInt(item.split(" ")[0]);
                Log.d("ID PRODUKTU: : ", log);
            }
        });


        dayAddDbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView nameTextView = (TextView) findViewById(R.id.nameDayTextView);
                final TextView kcalTextView = (TextView) findViewById(R.id.kcalDayTextView);

                final String nameTextValue = nameTextView.getText().toString();
                final String kcalTextValue = kcalTextView.getText().toString();
                db.addDay(new Day(nameTextValue, Integer.parseInt(kcalTextValue)));
                for (int prod_id : prod_ids){
                    db.addDay_Prod(prod_id,days.size()+1);
                    String log = "Id: " + days.size();
                    Log.d("ID PRODUKTU: : ", log);
                }

                startActivity(dayViewActivityIntent);

            }
        });
    }
}
