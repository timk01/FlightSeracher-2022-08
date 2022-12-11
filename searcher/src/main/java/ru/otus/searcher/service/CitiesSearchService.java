package ru.otus.searcher.service;

import dto.CityDto;
import lombok.NonNull;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.searcher.configuration.TravelPayoutProperties;

import java.util.List;

@Service
public class CitiesSearchService {
    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    public CitiesSearchService(RestTemplate restTemplate, TravelPayoutProperties travelPayoutProperties) {
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("https")
                .setHost(travelPayoutProperties.getUrl())
                .setPath(travelPayoutProperties.getCitiesPath())
                .addParameter(travelPayoutProperties.getLocaleKey(), travelPayoutProperties.getLocaleValue())
        ;
    }

    public List<CityDto> getCities() {
        @NonNull
        CityDto[] responseArray = restTemplate.getForEntity(builder.toString(), CityDto[].class).getBody();
        return List.of(responseArray);
    }
}
