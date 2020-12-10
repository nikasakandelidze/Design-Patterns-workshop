package com.designpatterns.priceserivce.utils;


import com.designpatterns.priceserivce.storage.entities.PriceEntity;
import com.designpatterns.priceserivce.web.dto.PriceDto;

public class Mapper {
    public static PriceEntity getPriceEntityFromPriceDto(PriceDto priceDto){
        PriceEntity imageEntity = new PriceEntity();
        imageEntity.setDetails(priceDto.getDetails());
        imageEntity.setPrice(priceDto.getPrice());
        return imageEntity;
    }

    public static PriceDto getPriceDtoFromPriceEntity(PriceEntity priceEntity){
        PriceDto imageDto = new PriceDto();
        imageDto.setDetails(priceEntity.getDetails());
        imageDto.setPrice(priceEntity.getPrice());
        return imageDto;
    }

}
