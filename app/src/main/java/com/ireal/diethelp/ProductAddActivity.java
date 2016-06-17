package com.ireal.diethelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


public class ProductAddActivity extends AppCompatActivity {
    TextView nameTextView, wheyTextView, fatTextView, carbTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
        final Button productAddDbButton = (Button) findViewById(R.id.addProdDb_button);
        final DBHandler db = new DBHandler(this);
        final Intent productViewActivityIntent = new Intent(this, ProductViewActivity.class);

        productAddDbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
                final TextView fatTextView = (TextView) findViewById(R.id.fatTextView);
                final TextView wheyTextView = (TextView) findViewById(R.id.wheyTextView);
                final TextView carbTextView = (TextView) findViewById(R.id.carbTextView);

                final String nameTextValue = nameTextView.getText().toString();
                final String fatTextValue = fatTextView.getText().toString();
                final String carbTextValue = wheyTextView.getText().toString();
                final String wheyTextValue = carbTextView.getText().toString();
                db.addProduct(new Product(nameTextValue, Integer.parseInt(wheyTextValue),Integer.parseInt(carbTextValue),Integer.parseInt(fatTextValue)));
                startActivity(productViewActivityIntent);
            }
        });

    }
}