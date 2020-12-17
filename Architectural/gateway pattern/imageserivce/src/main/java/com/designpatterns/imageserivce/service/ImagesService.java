package com.designpatterns.imageserivce.service;

import com.designpatterns.imageserivce.web.dto.ImageDto;

public interface ImagesService {
    ImageDto getImageWithId(String id);
    void addImage(ImageDto imageDto);
}
