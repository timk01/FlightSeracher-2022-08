package ru.otus.flightsearch.service;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.flightsearch.configuration.BotServiceProperties;

@Service
@Slf4j
public class BotServiceTravelPayout implements BotSearchService {

    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public BotServiceTravelPayout(RestTemplate restTemplate, BotServiceProperties botServiceProperties) {
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("http")
                .setHost(botServiceProperties.getTravelPayoutDataHost())
                .setPath(botServiceProperties.getTicketsPath());
    }

    @Override
    public SearchResultDtoList getDtoTicketList(SearchRequestDto dto) {
        SearchResultDtoList body = restTemplate.postForEntity(builder.toString(), dto, SearchResultDtoList.class).getBody();
        if (body != null) {
            log.info("body: {}", body.toString());
        }
        return body;
    }
}
