package com.designpattern.gateway.utils;

import com.designpattern.gateway.requester.dto.ImageProductDto;
import com.designpattern.gateway.service.clients.dto.ImageDto;
import com.designpattern.gateway.service.clients.dto.PriceDto;

public class Mapper {
    public static ImageProductDto getProductFromImageAndPrice(ImageDto imageDto, PriceDto priceDto){
        ImageProductDto imageProductDto = new ImageProductDto();
        imageProductDto.setPrice(priceDto.getPrice());
        imageProductDto.setDetails(priceDto.getDetails());
        imageProductDto.setName(imageDto.getImageName());
        imageProductDto.setDate(imageDto.getImageDate());
        return imageProductDto;
    }
}
