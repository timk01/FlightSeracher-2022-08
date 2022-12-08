package ru.otus.flightsearch.service;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.flightsearch.configuration.BotServiceProperties;

@Service
@Slf4j
public class BotServiceTravelPayout {

    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public BotServiceTravelPayout(RestTemplateBuilder restTemplateBuilder, BotServiceProperties botServiceProperties) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
        this.builder = new URIBuilder()
                .setScheme("http")
                .setHost(botServiceProperties.getTravelPayoutDataHost())
                .setPath(botServiceProperties.getTicketsPath());
    }

    public SearchResultDtoList getDtoTicketList(SearchRequestDto dto) {
        HttpStatus statusCode = restTemplate
                .postForEntity(builder.toString(), dto, SearchResultDtoList.class).getStatusCode();
        /*ResponseEntity<SearchResultDtoList> searchResultDtoListResponseEntity = restTemplate
                .postForEntity(builder.toString(), dto, SearchResultDtoList.class);*/
        SearchResultDtoList searchResultDtoList = new SearchResultDtoList();
        if (statusCode.equals(HttpStatus.BAD_REQUEST)) {
            return searchResultDtoList;
        }
        else if (statusCode.equals(HttpStatus.OK)){
            searchResultDtoList = restTemplate
                    .postForEntity(builder.toString(), dto, SearchResultDtoList.class).getBody();
            if (searchResultDtoList != null) {
                log.info("body: {}", searchResultDtoList.toString());
            }
        }
        return searchResultDtoList;
    }
}
