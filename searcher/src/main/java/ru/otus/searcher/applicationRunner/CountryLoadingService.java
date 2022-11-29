package ru.otus.searcher.applicationRunner;

import dto.CountryDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.searcher.controllers.CountrySearchController;
import ru.otus.searcher.entity.Country;
import ru.otus.searcher.repository.CountryRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CountryLoadingService implements DataLoader {

    private final CountrySearchController countrySearchController;
    private final CountryRepository countryRepository;
    private final Converter<CountryDto, Country> converter;

    @Override
    public void load() {
        List<CountryDto> countries = countrySearchController.getCountries();
        log.info("countries counter got from travelPayout: {}", countries.size());
        List<Country> convertedEntitiesList = countries.stream().map(converter::convert).toList();
        log.info("converted countries: {}", convertedEntitiesList.size());
        List<Country> countriesSavedToDb = countryRepository.saveAll(convertedEntitiesList);
        log.info("countries saved to DB {}", countriesSavedToDb.size());
    }
}
