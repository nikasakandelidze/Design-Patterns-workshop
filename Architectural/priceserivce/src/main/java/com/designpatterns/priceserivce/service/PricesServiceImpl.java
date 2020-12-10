package com.designpatterns.priceserivce.service;


import com.designpatterns.priceserivce.storage.Storage;
import com.designpatterns.priceserivce.storage.entities.PriceEntity;
import com.designpatterns.priceserivce.utils.Mapper;
import com.designpatterns.priceserivce.web.dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class PricesServiceImpl implements PricesService {
    private final Storage storage;

    @Autowired
    public PricesServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public PriceDto getImageWithId(String id) {
        PriceEntity imageEntityById = storage.getPriceEntityOfImageById(id);
        return Mapper.getPriceDtoFromPriceEntity(imageEntityById);
    }

    @Override
    public void addImage(PriceDto imageDto) {
        storage.addPriceEntity(Mapper.getPriceEntityFromPriceDto(imageDto));
    }
}
