package com.designpattern.gateway.requester;

import com.designpattern.gateway.requester.dto.ImageProductDto;
import com.designpattern.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayController {
    private final GatewayService gatewayService;

    @Autowired
    public GateWayController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @GetMapping("/api/products/{productId}")
    public ResponseEntity<ImageProductDto> getProduct(@PathVariable String productId, @RequestBody String privateKey){
        return ResponseEntity.ok(gatewayService.getImageProductById(productId,privateKey));
    }
}
