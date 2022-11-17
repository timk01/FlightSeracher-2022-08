package ru.otus.flightsearch.service;

import common_dto.AirportDto;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.flightsearch.model.AirportListModel;

import java.util.List;
import java.util.Objects;


@Service
public class BotServiceAirports {
    private final RestTemplate restTemplate;
    private final URIBuilder uriBuilder;

    public BotServiceAirports(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/api/airport-search");
    }

    public AirportListModel getAirports(){
       AirportDto[] body = restTemplate.getForEntity(uriBuilder.toString(),AirportDto[].class).getBody();
       return new AirportListModel(body);
    }
}
