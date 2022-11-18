package ru.otus.searcher.service;

import ru.otus.searcher.configuration.TravelPayoutProperties;
import ru.otus.searcher.converter.TicketSearchResultToSearchResultDTOConverter;
import ru.otus.searcher.model.TicketSearchResult;
import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class TicketListServiceTravelPayout implements TicketListService {

    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public TicketListServiceTravelPayout(RestTemplate restTemplate, TravelPayoutProperties travelPayoutProperties) {

        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("https")
                .setHost(travelPayoutProperties.getUrl())
                .setPath(travelPayoutProperties.getSearchPath())
                .addParameter("origin", "MOW")
                .addParameter("destination", "LON")
                .addParameter("sorting", "price")
                .addParameter("trip_class", "0")
                .addParameter("currency", "rub")
                .addParameter("limit", "10")
                .addParameter("page", "1")
                .addParameter("token", travelPayoutProperties.getToken());

    }

    @Override
    public SearchResultDtoList getDtoTicketList(SearchRequestDto dto) {
        //

        ResponseEntity<TicketSearchResult> response = restTemplate
                .getForEntity(
                        builder.toString(),
                        TicketSearchResult.class
                );

        return TicketSearchResultToSearchResultDTOConverter
                .convert(Objects
                        .requireNonNull(response
                                .getBody()));
    }
}
