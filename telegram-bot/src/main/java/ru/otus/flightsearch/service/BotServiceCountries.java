package ru.otus.flightsearch.service;

import common_dto.CountryDto;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.flightsearch.model.CountryListModel;
import ru.otus.flightsearch.model.CountryModel;

import java.util.List;

@Service
public class BotServiceCountries implements BotCountrySearchService {



    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public BotServiceCountries(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/api/country-search");
    }

    @Override
    public CountryListModel obtainCountriesList() {
        return restTemplate.getForEntity(builder.toString(), CountryListModel.class).getBody();
    }
}
