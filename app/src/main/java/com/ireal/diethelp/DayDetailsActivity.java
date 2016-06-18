package com.ireal.diethelp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class DayDetailsActivity extends AppCompatActivity {
    TextView dayName, dayKcal,dayMessageKcal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_details);
        final DBHandler db = new DBHandler(this);

        dayName = (TextView)findViewById(R.id.dayNameTextView);
        dayKcal = (TextView)findViewById(R.id.dayKcalTextView);
        dayMessageKcal = (TextView)findViewById(R.id.dayMessageKcalTextView);
        String id = getIntent().getStringExtra("address");
        ListView listView = (ListView) findViewById(R.id.product_list_view);
        List<Product> products = db.getIdProducts(Integer.parseInt(id));
        final String[] pages = new String[products.size()];
        int kcal = 0;
        int i= 0;
        Day day = db.getDay(Integer.parseInt(id));
        dayName.setText(day.getName());
        dayMessageKcal.setText("Zaplanowane kalorie "+ day.getKcal());
        for (Product product : products) {
            if(i <= products.size()){
                pages[i] =product.getId() + " " + product.getName() + " Białko: " + product.getWhey() + " Węglowodany: " + product.getCarb() + " Tłuszcz: " + product.getFat();
                kcal += product.getCarb()*4 + product.getWhey()*4 + product.getFat() *9;
                i++;}
        }
        if (day.getKcal() < kcal) {

            dayMessageKcal.setText("Suma kalorii produktów nie spełniaja założonej wartości kalorycznej. Różnica: "+ (day.getKcal()-kcal));
        }else{
            dayKcal.setText("Suma kalorii produktów przekracza założoną wartość kaloryczną. Różnica: "+ (kcal-day.getKcal()));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, pages);
        listView.setAdapter(adapter);
    }

}
