package com.designpatterns.priceserivce.web.dto;

public class PriceDto {
    private String price;
    private String details;

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
