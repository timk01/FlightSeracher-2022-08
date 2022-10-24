package com.example.searcher.service;

import com.example.searcher.dtos.CountryDto;
import lombok.NonNull;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class CountrySearchService {
    private RestTemplate restTemplate;
    private URIBuilder builder;

    public CountrySearchService(RestTemplate restTemplate, TravelPayoutProperties travelPayoutProperties) throws URISyntaxException {
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("https")
                .setHost(travelPayoutProperties.getUrl())
                .setPath(travelPayoutProperties.getCountriesUrl());
    }


    public List<CountryDto> getCountry(){
        @NonNull
        CountryDto[] responseArray = restTemplate.getForEntity(builder.toString(),CountryDto[].class).getBody();
        return List.of(responseArray);
    }
}
