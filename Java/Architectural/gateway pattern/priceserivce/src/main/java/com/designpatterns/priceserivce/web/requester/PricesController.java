package com.designpatterns.priceserivce.web.requester;

import com.designpatterns.priceserivce.service.PricesService;
import com.designpatterns.priceserivce.web.dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PricesController {
    private final PricesService service;

    @Autowired
    public PricesController(PricesService service) {
        this.service = service;
    }

    @GetMapping("/prices/{imageId}")
    public ResponseEntity<PriceDto> getPriceOfImageWithId(@PathVariable String imageId){
        return ResponseEntity.ok(service.getImageWithId(imageId));
    }

    @PostMapping("/prices")
    public ResponseEntity<?> addNewPrice(@RequestBody PriceDto priceDto){
        service.addImage(priceDto);
        return ResponseEntity.ok("OK");
    }

}
