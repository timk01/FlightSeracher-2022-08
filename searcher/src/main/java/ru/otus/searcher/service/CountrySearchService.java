package ru.otus.searcher.service;

import dto.CountryDto;
import lombok.NonNull;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.searcher.configuration.TravelPayoutProperties;

import java.util.List;

@Service
public class CountrySearchService {
    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    public CountrySearchService(RestTemplate restTemplate, TravelPayoutProperties travelPayoutProperties) {
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("https")
                .setHost(travelPayoutProperties.getUrl())
                .setPath(travelPayoutProperties.getCountriesPath());
    }

    public List<CountryDto> getCountry() {
        @NonNull
        CountryDto[] responseArray = restTemplate.getForEntity(builder.toString(), CountryDto[].class).getBody();
        return List.of(responseArray);
    }
}
