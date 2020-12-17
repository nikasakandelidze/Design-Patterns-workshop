package com.designpatterns.imageserivce.service;

import com.designpatterns.imageserivce.storage.entities.ImageEntity;
import com.designpatterns.imageserivce.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.designpatterns.imageserivce.storage.Storage;
import com.designpatterns.imageserivce.web.dto.ImageDto;

@Service
class ImagesServiceImpl implements ImagesService{
    private final Storage storage;

    @Autowired
    public ImagesServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public ImageDto getImageWithId(String id) {
        ImageEntity imageEntityById = storage.getImageEntityById(id);
        return Mapper.getImageDtoFromImageEntity(imageEntityById);
    }

    @Override
    public void addImage(ImageDto imageDto) {
        storage.addImageEntity(Mapper.getImageEntityFromImageDto(imageDto));
    }
}
