package com.example.searcher.service;

import com.example.searcher.model.Data;
import com.example.searcher.model.Data2;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TicketListServiceImpl implements TicketListService{

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

/*
    final String ROOT_URI = "https://api.travelpayouts.com/v2/prices/latest?origin=MOW&destination=LON&one_way=true&sorting=price&trip_class=0&currency=rub&limit=30&page=1&token=fc51222b5efbb95d3343a569c47f6c84";
*/

    @Override
    public Data2 getTicketList() {
        ResponseEntity<Data2> response = restTemplate.getForEntity(builder.toString(), Data2.class);
        return response.getBody();
    }

    @Override
    public List<Data> getTicketListRoughImpl() {

        /*ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        ResponseEntity<List<Ticket>> rateResponse =
                restTemplate.exchange(builder.toString(),
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });
        return rateResponse.getBody();*/

        ResponseEntity<Data[]> response = restTemplate.getForEntity(builder.toString(), Data[].class);
        Data[] body = response.getBody();
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
