package ru.otus.searcher.applicationRunner;

import dto.CityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.searcher.controllers.CitiesSearchController;
import ru.otus.searcher.converter.CityDtoToCityEntityConverter;
import ru.otus.searcher.entity.City;
import ru.otus.searcher.repository.CityRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityLoadingService implements DataLoader{

    private final CitiesSearchController citiesSearchController;
    private final CityRepository cityRepository;

    @Transactional
    @Override
    public void load() {
        List<CityDto> listOfCities = citiesSearchController.getListOfCities();
        if (!listOfCities.isEmpty()) {
            List<City> entities = CityDtoToCityEntityConverter.convert(listOfCities);
            /*System.out.println(entities.get(0).getCode());
            System.out.println(entities.get(1).getCode());
            cityRepository.save(entities.get(0));
            cityRepository.save(entities.get(1));*/
            cityRepository.saveAll(entities);
            //List<City> all = cityRepository.findAll();

            //log.info("presumably saved elements " + String.valueOf(cityRepository.count()));
            //log.info("really saved elements " + all);
        }
    }
}
