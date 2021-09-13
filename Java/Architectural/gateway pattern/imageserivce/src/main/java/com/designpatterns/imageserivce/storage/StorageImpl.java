package com.designpatterns.imageserivce.storage;

import org.springframework.stereotype.Component;
import com.designpatterns.imageserivce.storage.entities.ImageEntity;

import java.util.HashMap;
import java.util.Map;

@Component
class StorageImpl implements Storage {
    private Map<String, ImageEntity> storage = new HashMap<>();

    public StorageImpl(){
        Bootstrapper.bootstrapMapWithInitialValues(storage);
    }

    @Override
    public ImageEntity getImageEntityById(String imageId) {
        return storage.get(imageId);
    }

    @Override
    public void addImageEntity(ImageEntity imageEntity) {
        storage.put(storage.size() + "", imageEntity);
    }
}
