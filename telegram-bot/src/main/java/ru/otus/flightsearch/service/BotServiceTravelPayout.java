package ru.otus.flightsearch.service;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import ru.otus.flightsearch.configuration.BotServiceProperties;
import ru.otus.flightsearch.exception.WrongCityDataException;

@Service
@Slf4j
public class BotServiceTravelPayout {

    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public BotServiceTravelPayout(RestTemplateBuilder restTemplateBuilder, BotServiceProperties botServiceProperties) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new MockErrorHandler())
                .build();

        this.builder = new URIBuilder()
                .setScheme("http")
                .setHost(botServiceProperties.getTravelPayoutDataHost())
                .setPath(botServiceProperties.getTicketsPath());
    }

    public SearchResultDtoList getDtoTicketList(SearchRequestDto requestDto) {
        ResponseEntity<String> entity = restTemplate.postForEntity(builder.toString(), requestDto, String.class);
        SearchResultDtoList searchResultDtoList;
        if (HttpStatus.BAD_REQUEST == entity.getStatusCode()) {
            throw new WrongCityDataException("Cannot get data due to wrong city name");
        }
        searchResultDtoList = restTemplate
                .postForEntity(builder.toString(), requestDto, SearchResultDtoList.class).getBody();
        if (searchResultDtoList != null) {
            log.info("body: {}", searchResultDtoList.toString());
        }
        return searchResultDtoList;
    }
}

