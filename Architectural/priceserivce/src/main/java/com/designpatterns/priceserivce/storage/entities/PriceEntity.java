package com.designpatterns.priceserivce.storage.entities;

public class PriceEntity {
    private String price;
    private String details;

    public PriceEntity(String price, String details) {
        this.price = price;
        this.details = details;
    }

    public PriceEntity(){}

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
