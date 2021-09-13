package com.designpatterns.imageserivce.storage;

import com.designpatterns.imageserivce.storage.entities.ImageEntity;

public interface Storage {

    ImageEntity getImageEntityById(String imageId);

    void addImageEntity(ImageEntity imageEntity);
}
