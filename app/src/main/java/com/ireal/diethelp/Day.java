package com.ireal.diethelp;

/**
 * Created by ireal on 17.06.2016.
 */
public class Day {
    private int id;
    private String name;
    public Day(){

    }
    public Day (String name){
        this.name=name;
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
}
