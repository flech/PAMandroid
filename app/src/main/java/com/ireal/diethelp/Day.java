package com.ireal.diethelp;

/**
 * Created by ireal on 17.06.2016.
 */
public class Day {
    private int id;
    private String name;
    private int kcal;
    public Day(){

    }
    public Day (String name,int kcal){
        this.name=name;
        this.kcal=kcal;
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

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }
}
