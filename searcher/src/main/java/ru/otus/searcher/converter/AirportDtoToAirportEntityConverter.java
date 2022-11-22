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
public class AirportDtoToAirportEntityConverter implements Converter<List<AirportDto>, List<Airport>> {

    @Override
    public List<Airport> convert(List<AirportDto> airports) {
        List<Airport> airportList = new ArrayList<>();

        for (AirportDto airportFromDto : airports) {
            airportList.add(new Airport()
                    .setCode(airportFromDto.getCode())
                    .setName(airportFromDto.getName())
                    //.setCountry(new Country().setCode(airportFromDto.getCountryCode()))
                    .setCity(new City().setCode(airportFromDto.getCityCode())))
                    ;
        }
        return airportList;
    }
}
