package ru.otus.flightsearch.service;

import DTO.AirportDto;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BotServiceAirports {
    private final RestTemplate restTemplate;
    private final URIBuilder uriBuilder;

    public BotServiceAirports(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/api/airports");
    }

    public AirportDto[] getAirports(){
       AirportDto[] body = restTemplate.getForEntity(uriBuilder.toString(),AirportDto[].class).getBody();
       return body;
    }
}
