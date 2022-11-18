package ru.otus.flightsearch.service;

import dto.CountryDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BotServiceCountries{

    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public BotServiceCountries(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/api/countries");
    }

        public CountryDto[] obtainCountriesList() {
        log.info(builder.toString());
        CountryDto[] body = restTemplate.getForEntity(builder.toString(), CountryDto[].class).getBody();
        return body;
    }
}
