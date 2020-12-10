package com.designpatterns.imageserivce.storage.entities;

public class ImageEntity {
    private String name;
    private String date;

    public ImageEntity(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public ImageEntity(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
