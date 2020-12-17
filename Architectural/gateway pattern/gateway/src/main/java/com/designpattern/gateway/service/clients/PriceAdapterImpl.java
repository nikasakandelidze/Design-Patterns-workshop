package com.designpattern.gateway.service.clients;

import com.designpattern.gateway.service.clients.dto.ImageDto;
import com.designpattern.gateway.service.clients.dto.PriceDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class PriceAdapterImpl implements PriceAdapter {
    //This object is threadsafe so let it be here, creating it every time will be inefficient
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PriceDto getPriceOfImageById(String id) {
        var httpClient = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8086/imageprices/"+id))
                .build();
        try {

            HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(send.body(), PriceDto.class);

        } catch (IOException | InterruptedException e) {

            return new PriceDto();

        }
    }
}
