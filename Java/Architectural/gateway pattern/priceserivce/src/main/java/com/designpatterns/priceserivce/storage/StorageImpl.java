package com.designpatterns.priceserivce.storage;

import com.designpatterns.priceserivce.storage.entities.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class StorageImpl implements Storage {
    private Map<String, PriceEntity> storage = new HashMap<>();

    public StorageImpl(){
        Bootstrapper.bootstrapMapWithInitialValues(storage);
    }

    @Override
    public PriceEntity getPriceEntityOfImageById(String imageId) {
        return storage.get(imageId);
    }

    @Override
    public void addPriceEntity(PriceEntity imageEntity) {
        storage.put(storage.size() + "", imageEntity);
    }
}
