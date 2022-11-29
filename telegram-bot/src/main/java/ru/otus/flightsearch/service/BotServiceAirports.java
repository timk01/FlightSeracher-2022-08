package ru.otus.flightsearch.service;

import dto.AirportDto;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.flightsearch.configuration.BotServiceProperties;

@Service
public class BotServiceAirports {
    private final RestTemplate restTemplate;
    private final URIBuilder uriBuilder;

    public BotServiceAirports(RestTemplate restTemplate, BotServiceProperties botServiceProperties) {
        this.restTemplate = restTemplate;
        this.uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost(botServiceProperties.getTravelPayoutDataHost())
                .setPath(botServiceProperties.getAirportPath());
    }

    public AirportDto[] getAirports() {
        AirportDto[] body = restTemplate.getForEntity(uriBuilder.toString(), AirportDto[].class).getBody();
        return body;
    }
}
