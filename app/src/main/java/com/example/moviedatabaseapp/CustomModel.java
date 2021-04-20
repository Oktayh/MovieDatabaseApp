package com.example.moviedatabaseapp;

import androidx.annotation.NonNull;

public class CustomModel {
    private String status;
    private int id;
    private String name;
    private String genra;
    private int year;

    public  CustomModel(){

    }

    public CustomModel(int id, String name, String genre, int year,String status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.genra = genre;
        this.year = year;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
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
