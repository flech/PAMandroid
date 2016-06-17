package com.ireal.diethelp;

/**
 * Created by ireal on 17.06.2016.
 */
public class Product {

    private int id;
    private String name;
    private int whey;
    private int fat;
    private int carb;
    public Product(){

    }
    public Product (String name, int whey,int carb, int fat){
        this.name=name;
        this.carb=carb;
        this.whey=whey;
        this.fat=fat;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWhey() {
        return whey;
    }

    public void setWhey(int whey) {
        this.whey = whey;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarb() {
        return carb;
    }

    public void setCarb(int carb) {
        this.carb = carb;
    }
}
