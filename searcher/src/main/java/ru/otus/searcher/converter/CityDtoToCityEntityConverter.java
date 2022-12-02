package ru.otus.searcher.converter;

import dto.CityDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.searcher.entity.City;
import ru.otus.searcher.entity.Country;

@Component
public class CityDtoToCityEntityConverter implements Converter<CityDto, City> {

    @Override
    public City convert(CityDto cityDto) {
        return new City()
                .setCode(cityDto.getCode())
                .setName(cityDto.getName())
                .setCountry(new Country().setCode(cityDto.getCountryCode()))
                ;
    }
}
