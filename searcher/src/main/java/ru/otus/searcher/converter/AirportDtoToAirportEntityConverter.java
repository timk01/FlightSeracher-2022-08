package ru.otus.searcher.converter;

import dto.AirportDto;
import dto.CityDto;
import lombok.experimental.UtilityClass;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.searcher.entity.Airport;
import ru.otus.searcher.entity.City;
import ru.otus.searcher.entity.Country;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirportDtoToAirportEntityConverter implements Converter<AirportDto, Airport> {

    @Override
    public Airport convert(AirportDto airport) {
        return new Airport()
                .setCode(airport.getCode())
                .setName(airport.getName())
                .setCountry(new Country().setCode(airport.getCountryCode()))
                .setCity(new City().setCode(airport.getCityCode()))
                ;
    }
}