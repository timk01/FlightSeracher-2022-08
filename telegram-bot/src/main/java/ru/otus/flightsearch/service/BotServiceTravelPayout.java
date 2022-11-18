package ru.otus.flightsearch.service;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BotServiceTravelPayout implements BotSearchService {

    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public BotServiceTravelPayout(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/api/search");
    }

    @Override
    public SearchResultDtoList getDtoTicketList(SearchRequestDto dto) {
        return restTemplate.postForEntity(builder.toString(), dto,  SearchResultDtoList.class).getBody();
    }
}
