package ru.otus.searcher.applicationRunner;

import dto.CountryDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.searcher.controllers.CountrySearchController;
import ru.otus.searcher.entity.Country;
import ru.otus.searcher.repository.CountryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CountryLoadingService implements DataLoader{
    private final CountrySearchController countrySearchController;
    private final CountryRepository countryRepository;

    @Override
    public void load() {
        List<CountryDto> countries = countrySearchController.getCountries();
        List<Country> dtoToEntity = convert(countries);
        List<Country> countriesSavedToDb = countryRepository.saveAll(dtoToEntity);

        log.info("countries counter got from travelPayout: {}", countries.size());
        log.info("saved DB countries: {}", dtoToEntity.size());
        log.info("countries counter saved to DB {}", countriesSavedToDb.size());

    }

    private List<Country> convert(List<CountryDto> countries) {
        Country countryEntity;
        List<Country> entityList = new ArrayList<>();

        for (CountryDto dto : countries){
            countryEntity = new Country()
                    .setName(dto.getName())
                    .setCode(dto.getCode());
            entityList.add(countryEntity);
        }

        return entityList;
    }
}
