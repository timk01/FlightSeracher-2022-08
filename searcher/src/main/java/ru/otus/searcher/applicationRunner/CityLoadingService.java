package ru.otus.searcher.applicationRunner;

import dto.CityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.searcher.converter.CityDtoToCityEntityConverter;
import ru.otus.searcher.entity.City;
import ru.otus.searcher.repository.CityRepository;
import ru.otus.searcher.service.CitiesSearchService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityLoadingService implements DataLoader{

    private final CitiesSearchService citiesSearchService;
    private final CityRepository cityRepository;

    @Override
    public void load() {
        List<CityDto> listOfCities = citiesSearchService.getCities();
        log.info("cities counter got from travelPayout: {}", listOfCities.size());
        if (!listOfCities.isEmpty()) {
            List<City> entities = CityDtoToCityEntityConverter.convert(listOfCities);
            log.info("cities counter upon convertation: {}", entities.size());
            List<City> savedCityList = cityRepository.saveAll(entities);
            log.info("saved DB cities: {}", savedCityList.size());
        }
    }
}
