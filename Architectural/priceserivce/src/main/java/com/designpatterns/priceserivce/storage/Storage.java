package com.designpatterns.priceserivce.storage;


import com.designpatterns.priceserivce.storage.entities.PriceEntity;

public interface Storage {

    PriceEntity getPriceEntityOfImageById(String imageId);

    void addPriceEntity(PriceEntity imageEntity);
}
