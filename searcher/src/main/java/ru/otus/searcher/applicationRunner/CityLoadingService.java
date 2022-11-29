package ru.otus.searcher.applicationRunner;

import dto.CityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.searcher.entity.City;
import ru.otus.searcher.repository.CityRepository;
import ru.otus.searcher.service.CitiesSearchService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityLoadingService implements DataLoader {

    private final CitiesSearchService citiesSearchService;
    private final CityRepository cityRepository;
    private final Converter<CityDto, City> converter;

    @Override
    public void load() {
        List<CityDto> listOfCities = citiesSearchService.getCities();
        log.info("cities counter got from travelPayout: {}", listOfCities.size());
        if (!listOfCities.isEmpty()) {
            List<City> convertedEntitiesList = listOfCities.stream().map(converter::convert).toList();
            log.info("cities counter upon convertation: {}", convertedEntitiesList.size());
            List<City> savedCityList = cityRepository.saveAll(convertedEntitiesList);
            log.info("saved DB cities: {}", savedCityList.size());
        }
    }
}
