package com.example.searcher.service;


import com.example.searcher.configuration.TravelPayoutProperties;
import common_dto.AirportDto;
import lombok.NonNull;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportsSearchService {
    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    public AirportsSearchService(RestTemplate restTemplate, TravelPayoutProperties travelPayoutProperties) {
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("https")
                .setHost(travelPayoutProperties.getUrl())
                .setPath(travelPayoutProperties.getAirportsUrl());
    }


    public List<AirportDto> getAirports() {
        @NonNull
        AirportDto[] responseArray = restTemplate.getForEntity(builder.toString(), AirportDto[].class).getBody();
        List<AirportDto> listOfAirports = List.of(responseArray);

        return listOfAirports.stream()
                .filter(i->(i.isFlightable() && i.getIata_type().equals("airport")))
                .collect(Collectors.toList());
    }
}
