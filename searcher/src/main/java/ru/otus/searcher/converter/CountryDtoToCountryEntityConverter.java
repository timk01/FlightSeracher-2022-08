package ru.otus.searcher.converter;

import dto.CountryDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.searcher.entity.Country;

@Component
public class CountryDtoToCountryEntityConverter implements Converter<CountryDto, Country> {

    @Override
    public Country convert(CountryDto countryDto) {
        return new Country()
                .setName(countryDto.getName())
                .setCode(countryDto.getCode())
                ;
    }
}
