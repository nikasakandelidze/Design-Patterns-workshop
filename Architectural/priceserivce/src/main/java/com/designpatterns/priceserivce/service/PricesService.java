package com.designpatterns.priceserivce.service;


import com.designpatterns.priceserivce.web.dto.PriceDto;

public interface PricesService {
    PriceDto getImageWithId(String id);
    void addImage(PriceDto priceDto);
}
