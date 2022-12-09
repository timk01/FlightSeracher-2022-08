package ru.otus.searcher.service;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.searcher.configuration.TravelPayoutProperties;
import ru.otus.searcher.converter.TicketSearchResultToSearchResultDTOConverter;
import ru.otus.searcher.entity.City;
import ru.otus.searcher.exception.WrongCityDataException;
import ru.otus.searcher.model.TicketSearchResult;
import ru.otus.searcher.repository.CityRepository;

import java.util.Objects;
import java.util.Optional;

@Service
public class TicketListServiceTravelPayout implements TicketListService {

    private final RestTemplate restTemplate;
    private final URIBuilder builder;
    private final Converter<TicketSearchResult, SearchResultDtoList> converter;
    private final CityRepository cityRepository;

    @Autowired
    public TicketListServiceTravelPayout(RestTemplate restTemplate, TravelPayoutProperties travelPayoutProperties, TicketSearchResultToSearchResultDTOConverter converter, CityRepository cityRepository) {
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
        this.converter = converter;
        this.cityRepository = cityRepository;
    }

    @Override
    public SearchResultDtoList getDtoTicketList(SearchRequestDto dto) {
        Optional<City> originCity = cityRepository.findCityByName(dto.getOrigin());
        Optional<City> destinationCity = cityRepository.findCityByName(dto.getDestination());
        if (!(originCity.isPresent() && destinationCity.isPresent())) {
            throw new WrongCityDataException("Cannot find such CityName in DB");
        }
        String builderString = builder
                .setParameter("origin", /*"mo3"*/originCity.get().getCode())
                .setParameter("destination", destinationCity.get().getCode())
                .toString();
        ResponseEntity<TicketSearchResult> response = restTemplate
                .getForEntity(
                        builderString,
                        TicketSearchResult.class
                );
/*
        if (response)) { //check exception from TPO
            throw new WrongCityDataException("Wrong destination or origin!");
        }*/

        return converter
                .convert(Objects
                        .requireNonNull(response
                                .getBody()));
    }
}
