package com.example.searcher.service;

import com.example.searcher.configuration.TravelPayoutProperties;
import common_dto.CitiesDto;
import lombok.NonNull;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.beans.JavaBean;
import java.util.List;

@Service
public class CitiesSearchService {
    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    public CitiesSearchService(RestTemplate restTemplate, TravelPayoutProperties travelPayoutProperties){
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("https")
                .setHost(travelPayoutProperties.getUrl())
                .setPath(travelPayoutProperties.getCitiesUrl());
    }

    public List<CitiesDto> getCities(){
        @NonNull
        CitiesDto[] responseArray = restTemplate.getForEntity(builder.toString(),CitiesDto[].class).getBody();
        return List.of(responseArray);
    }
}
