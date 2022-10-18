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
public class TicketListServiceTravelPayout implements TicketListService{

    @Autowired
    RestTemplate restTemplate;

    URIBuilder builder = new URIBuilder()
            .setScheme("https")
            .setHost("api.travelpayouts.com")
            .setPath("/v2/prices/latest")
            .addParameter("origin", "MOW")
            .addParameter("destination", "LON")
            .addParameter("sorting", "price")
            .addParameter("trip_class", "0")
            .addParameter("currency", "rub")
            .addParameter("limit", "30")
            .addParameter("page", "1")
            .addParameter("token", Token.secretToken);

    @Override
    public SearchResultDtoList getDtoTicketList() {
        ResponseEntity<TicketSearchResult> response = restTemplate.getForEntity(builder.toString(), TicketSearchResult.class);
        return TicketSearchResultToSearchResultDTOConverter.convert(Objects.requireNonNull(response.getBody()));
    }
}
