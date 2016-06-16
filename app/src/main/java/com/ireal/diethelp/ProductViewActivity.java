package com.ireal.diethelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ProductViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);
        ListView listView = (ListView) findViewById(R.id.product_list_view);
        final Button productAddButton = (Button) findViewById(R.id.addProd_button);
        final Intent productAddActivityIntent = new Intent(this, ProductAddActivity.class);

        final String[] pages = new String[3];
        pages[0] = "Ryż 100g";
        pages[1] = "Watroba 100g";
        pages[2] = "Pizza 500g";
        productAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(productAddActivityIntent);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, pages);

        listView.setAdapter(adapter);


    }
}
