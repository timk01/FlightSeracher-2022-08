package com.example.searcher.service;

import com.example.searcher.converter.TicketSearchResultToSearchResultDTOConverter;
import com.example.searcher.model.TicketSearchResult;
import com.example.searcher.dtos.SearchResultDtoList;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class TicketListServiceTravelPayout implements TicketListService {

    private final RestTemplate restTemplate;
    private final TravelPayoutProperties travelPayoutProperties;
    private final URIBuilder builder;

    @Autowired
    public TicketListServiceTravelPayout(RestTemplate restTemplate, TravelPayoutProperties travelPayoutProperties) {
        this.restTemplate = restTemplate;
        this.travelPayoutProperties = travelPayoutProperties;
        this.builder = new URIBuilder()
                .setScheme("https")
                .setHost(travelPayoutProperties.getUrl())
                .setPath(travelPayoutProperties.getSearchUrl())
                .addParameter("origin", "MOW")
                .addParameter("destination", "LON")
                .addParameter("sorting", "price")
                .addParameter("trip_class", "0")
                .addParameter("currency", "rub")
                .addParameter("limit", "30")
                .addParameter("page", "1")
                .addParameter("token", travelPayoutProperties.getToken());
    }

    @Override
    public SearchResultDtoList getDtoTicketList() {
        ResponseEntity<TicketSearchResult> response = restTemplate.getForEntity(builder.toString(), TicketSearchResult.class);
        return TicketSearchResultToSearchResultDTOConverter.convert(Objects.requireNonNull(response.getBody()));
    }
}
