package ru.otus.searcher.applicationRunner;

import dto.AirportDto;
import dto.CityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.searcher.converter.CityDtoToCityEntityConverter;
import ru.otus.searcher.entity.Airport;
import ru.otus.searcher.entity.City;
import ru.otus.searcher.repository.AirportRepository;
import ru.otus.searcher.repository.CityRepository;
import ru.otus.searcher.service.AirportsSearchService;
import ru.otus.searcher.service.CitiesSearchService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirportLoadingService implements DataLoader{

    private final AirportsSearchService airportsSearchService;
    private final AirportRepository airportRepository;
    private final Converter<AirportDto, Airport> converter;
    // private final Converter<List<AirportDto>, List<Airport>> converter;

    @Override
    public void load() {
        List<AirportDto> airportsFromTravelPayout = airportsSearchService.getAirports();
        log.info("airports counter got from travelPayout: {}", airportsFromTravelPayout.size());
        if (!airportsFromTravelPayout.isEmpty()) {
            //List<Airport> convertedEntitiesList = converter.convert(airportsFromTravelPayout);
            List<Airport> convertedEntitiesList = airportsFromTravelPayout.stream().map(converter::convert).toList();
            log.info("airport counter upon convertation: {}", convertedEntitiesList.size());
            List<Airport> savedAirportList = airportRepository.saveAll(convertedEntitiesList);
            log.info("saved DB airports: {}", savedAirportList.size());
        }
    }
}
