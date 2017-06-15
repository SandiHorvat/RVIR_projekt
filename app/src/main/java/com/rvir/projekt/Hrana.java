package com.rvir.projekt;

/**
 * Created by Marko on 6/15/2017.
 */

public class Hrana {
    int _id;
    String _name;
    byte[] _image;
    int _calories;

   /*public Hrana(int id, String name, byte[] image, int calories) {
        this._id = id;
        this._name = name;
        this._image = image;
        this._calories = calories;
    }*/

    public Hrana(){

    }

    public Hrana(String name, byte[] image){
        this._name = name;
        this._image = image;


    }

    public Hrana(int id,String name, byte[] image){
        this._id = id;
        this._name = name;
        this._image = image;


    }

    public Hrana(String name, byte[] image, int calories){
        this._name = name;
        this._image = image;
        this._calories = calories;

    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public byte[] getImage() {
        return _image;
    }

    public void setImage(byte[] image) {
        this._image = image;
    }

    public int getCalories() {
        return _calories;
    }

    public void setCalories(int calories) {
        this._calories = calories;
    }
}
