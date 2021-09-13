package com.designpatterns.imageserivce.web.requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.designpatterns.imageserivce.web.dto.ImageDto;
import com.designpatterns.imageserivce.service.ImagesService;

@RestController
public class ImageController {
    private final ImagesService service;

    @Autowired
    public ImageController(ImagesService service) {
        this.service = service;
    }

    @GetMapping("/images/{imageId}")
    public ResponseEntity<ImageDto> getImageWithId(@PathVariable String imageId){
        return ResponseEntity.ok(service.getImageWithId(imageId));
    }

    @PostMapping("/images")
    public ResponseEntity<?> addNewImage(@RequestBody ImageDto imageDto){
        service.addImage(imageDto);
        return ResponseEntity.ok("OK");
    }

}
