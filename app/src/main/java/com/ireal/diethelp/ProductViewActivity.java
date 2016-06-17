package com.ireal.diethelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ProductViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);
        ListView listView = (ListView) findViewById(R.id.product_list_view);
        final Button productAddButton = (Button) findViewById(R.id.addProd_button);
        final Intent productAddActivityIntent = new Intent(this, ProductAddActivity.class);
        DBHandler db = new DBHandler(this);


//        db.addProduct(new Product("Ryż", 100,100,100));
//        db.addProduct(new Product("Mleko", 10,100,10));
//        db.addProduct(new Product("Kurczzak", 10,100,10));
        db.addDay(new Day("Poniedzialek",1000));
        db.addDay(new Day("Wtorek",2000));
        List<Product> products = db.getAllProducts();

        for (Product product : products) {
            String log = "Id: " + product.getId() + " ,Name: " + product.getName() + " ,WHEY: " + product.getWhey();
            Log.d("Product: : ", log);
        }
        final String[] pages = new String[products.size()];
        int i= 0;
        for (Product product : products) {
            if(i <= products.size()){
            pages[i] = product.getName() + " Białko: " + product.getWhey() + " Węglowodany: " + product.getCarb() + " Tłuszcz: " + product.getFat();
            i++;}
        }

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
