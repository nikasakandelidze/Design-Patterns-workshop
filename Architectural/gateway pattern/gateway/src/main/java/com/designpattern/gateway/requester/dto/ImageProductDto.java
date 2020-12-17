package com.designpattern.gateway.requester.dto;

public class ImageProductDto {
    private String name;
    private String date;
    private String price;
    private String details;

    public static ImageProductDto empty() {
        return new ImageProductDto();
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
