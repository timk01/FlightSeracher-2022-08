package ru.otus.flightsearch.service;

import com.example.searcher.converter.TicketSearchResultToSearchResultDTOConverter;
import com.example.searcher.dtos.SearchResultDtoList;
import com.example.searcher.model.TicketSearchResult;
import com.example.searcher.service.TravelPayoutProperties;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

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
                .setPath("/")
                .addParameter("origin", "MOW");
    }

    @Override
    public SearchResultDtoList getDtoTicketList() {
        ResponseEntity<TicketSearchResult> response = restTemplate.getForEntity(builder.toString(), TicketSearchResult.class);
        return TicketSearchResultToSearchResultDTOConverter.convert(Objects.requireNonNull(response.getBody()));
    }
}
