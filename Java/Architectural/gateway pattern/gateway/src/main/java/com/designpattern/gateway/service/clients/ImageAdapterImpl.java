package com.designpattern.gateway.service.clients;

import com.designpattern.gateway.service.clients.dto.ImageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
class ImageAdapterImpl implements ImageAdapter {
    //This object is threadsafe so let it be here, creating it every time will be inefficient
    private final   ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ImageDto getImageById(String id) {
        var httpClient = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8085/images/"+id))
                .build();
        try {

            HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(send.body(), ImageDto.class);

        } catch (IOException | InterruptedException e) {

            return new ImageDto();

        }
    }
}
