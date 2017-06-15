package com.rvir.projekt;

/**
 * Created by Marko on 6/15/2017.
 */

public class Hrana {
    int id;
    String name;
    byte[] image;
    int calories;

    public Hrana(int id, String name, byte[] image, int calories) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.calories = calories;
    }

    public Hrana(){

    }

    public Hrana(String name, byte[] image, int calories){

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
