package com.designpattern.gateway.service.clients;

import com.designpattern.gateway.service.clients.dto.ImageDto;

public interface ImageAdapter {
    ImageDto getImageById(String id);
}
