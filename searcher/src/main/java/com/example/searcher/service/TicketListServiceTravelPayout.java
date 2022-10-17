package com.example.searcher.service;

import com.example.searcher.converter.TicketSearchResultToSearchRsultDTOConverter;
import com.example.searcher.model.Ticket;
import com.example.searcher.model.TicketSearchResult;
import flightsearch.dtos.SearchResultDto;
import flightsearch.dtos.SearchResultDtoList;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
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
        return TicketSearchResultToSearchRsultDTOConverter.convert(Objects.requireNonNull(response.getBody()));
    }

    @Override
    public List<Ticket> getTicketListRoughImpl() {

        /*ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        ResponseEntity<List<Ticket>> rateResponse =
                restTemplate.exchange(builder.toString(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });
        return rateResponse.getBody();*/

        ResponseEntity<Ticket[]> response = restTemplate.getForEntity(builder.toString(), Ticket[].class);
        Ticket[] body = response.getBody();
        return Arrays.asList(body);
    }

/*    @Override
    public List<Ticket> getTicketListRoughImpl() {

        *//*ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        ResponseEntity<List<Ticket>> rateResponse =
                restTemplate.exchange(builder.toString(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });
        return rateResponse.getBody();*//*

        ResponseEntity<Ticket[]> response = restTemplate.getForEntity(builder.toString(), Ticket[].class);
        Ticket[] body = response.getBody();
        return Arrays.asList(body);
    }*/
}
