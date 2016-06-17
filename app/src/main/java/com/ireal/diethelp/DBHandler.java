package com.ireal.diethelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ireal on 17.06.2016.
 */
public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "myDatabase6";
    // Contacts table name
    private static final String TABLE_PRODUCTS = "products";
    private static final String TABLE_DAYS = "days";
    private static final String TABLE_DAYS_PRODS = "days_prods";

    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_DAY_ID = "id_day";
    private static final String KEY_PROD_ID = "id_prod";
    private static final String KEY_NAME = "name";
    private static final String KEY_WHEY = "whey";
    private static final String KEY_CARB = "carb";
    private static final String KEY_FAT= "fat";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_WHEY + " INT," + KEY_CARB + " INT," + KEY_FAT+ " INT" + ")";
        String CREATE_DAYS_TABLE = "CREATE TABLE " + TABLE_DAYS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" + ")";
        String CREATE_DAYS_PRODS_TABLE = "CREATE TABLE " + TABLE_DAYS_PRODS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DAY_ID + " INT," + KEY_PROD_ID + " INT" + ")";
        db.execSQL( CREATE_PRODUCTS_TABLE);
        db.execSQL( CREATE_DAYS_TABLE);
        db.execSQL( CREATE_DAYS_PRODS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        // Creating tables again
        onCreate(db);
    }

    // Adding new shop
    public void addProduct(Product prod) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, prod.getName());
        values.put(KEY_WHEY, prod.getWhey());
        values.put(KEY_FAT, prod.getFat());
        values.put(KEY_CARB, prod.getCarb());

// Inserting Row
        db.insert(TABLE_PRODUCTS, null, values);
        db.close(); // Closing database connection
    }
    public void addDay(Day day) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, day.getName());


// Inserting Row
        db.insert(TABLE_DAYS, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Shops
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(Integer.parseInt(cursor.getString(0)));
                product.setName(cursor.getString(1));
                product.setWhey(Integer.parseInt(cursor.getString(2)));
                product.setFat(Integer.parseInt(cursor.getString(3)));
                product.setCarb(Integer.parseInt(cursor.getString(4)));
                productList.add(product);
            } while (cursor.moveToNext());
        }

        return productList;
    }
    public List<Day> getAllDays() {
        List<Day> dayList = new ArrayList<Day>();

        String selectQuery = "SELECT * FROM " + TABLE_DAYS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Day day = new Day();
                day.setId(Integer.parseInt(cursor.getString(0)));
                day.setName(cursor.getString(1));

                dayList.add(day);
            } while (cursor.moveToNext());
        }

        return dayList;
    }
}

