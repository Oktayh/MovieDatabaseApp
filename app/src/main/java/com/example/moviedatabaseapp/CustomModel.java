package com.example.moviedatabaseapp;

import androidx.annotation.NonNull;

public class CustomModel {

    private int id;
    private String name;
    private String genra;
    private int year;

    public  CustomModel(){

    }

    public CustomModel(int id, String name, String genra, int year) {
        this.id = id;
        this.name = name;
        this.genra = genra;
        this.year = year;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenra() {
        return genra;
    }

    public int getYear() {
        return year;
    }
    @Override
    public String toString() {
        return "CustomModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genra='" + genra + '\'' +
                ", year=" + year +
                '}';
    }
}
