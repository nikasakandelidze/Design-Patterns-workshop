package com.designpattern.gateway.service;

import com.designpattern.gateway.requester.dto.ImageProductDto;
import com.designpattern.gateway.service.clients.ImageAdapter;
import com.designpattern.gateway.service.clients.PriceAdapter;
import com.designpattern.gateway.service.clients.dto.ImageDto;
import com.designpattern.gateway.service.clients.dto.PriceDto;
import com.designpattern.gateway.service.security.SecurityValidator;
import com.designpattern.gateway.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayServiceImpl implements GatewayService {
    private final ImageAdapter imageAdapter;
    private final PriceAdapter priceAdapter;
    private final SecurityValidator securityValidator;

    @Autowired
    public GatewayServiceImpl(ImageAdapter imageAdapter, PriceAdapter priceAdapter, SecurityValidator securityValidator) {
        this.imageAdapter = imageAdapter;
        this.priceAdapter = priceAdapter;
        this.securityValidator = securityValidator;
    }

    @Override
    public ImageProductDto getImageProductById(String id, String privateKey) {

        if(!securityValidator.isInputRequestValid(privateKey))
            return ImageProductDto.empty();

        ImageDto imageById = imageAdapter.getImageById(id);

        PriceDto priceOfImageById = priceAdapter.getPriceOfImageById(id);

        return Mapper.getProductFromImageAndPrice(imageById,priceOfImageById);
    }


}
