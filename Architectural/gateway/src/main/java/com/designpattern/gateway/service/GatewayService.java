package com.designpattern.gateway.service;

import com.designpattern.gateway.requester.dto.ImageProductDto;

public interface GatewayService {
    ImageProductDto getImageProductById(String id,String privateKey);
}
