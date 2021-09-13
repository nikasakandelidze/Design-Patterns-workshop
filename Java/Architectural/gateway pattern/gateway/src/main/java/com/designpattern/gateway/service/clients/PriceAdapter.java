package com.designpattern.gateway.service.clients;

import com.designpattern.gateway.service.clients.dto.PriceDto;

public interface PriceAdapter {
    PriceDto getPriceOfImageById(String id);
}
