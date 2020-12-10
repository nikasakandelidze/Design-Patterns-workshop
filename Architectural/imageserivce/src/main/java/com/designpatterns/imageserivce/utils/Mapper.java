package com.designpatterns.imageserivce.utils;

import com.designpatterns.imageserivce.storage.entities.ImageEntity;
import com.designpatterns.imageserivce.web.dto.ImageDto;

public class Mapper {
    public static ImageEntity getImageEntityFromImageDto(ImageDto imageDto){
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setDate(imageDto.getImageDate());
        imageEntity.setName(imageDto.getImageName());
        return imageEntity;
    }

    public static ImageDto getImageDtoFromImageEntity(ImageEntity imageEntity){
        ImageDto imageDto = new ImageDto();
        imageDto.setImageDate(imageEntity.getDate());
        imageDto.setImageName(imageEntity.getName());
        return imageDto;
    }

}
