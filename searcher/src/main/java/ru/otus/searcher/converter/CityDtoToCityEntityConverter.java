package ru.otus.searcher.converter;

import dto.CityDto;
import dto.SearchResultDto;
import dto.SearchResultDtoList;
import lombok.experimental.UtilityClass;
import ru.otus.searcher.entity.City;
import ru.otus.searcher.model.Ticket;
import ru.otus.searcher.model.TicketSearchResult;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CityDtoToCityEntityConverter {

    public List<City> convert(List<CityDto> cities) {

        List<City> cityList = new ArrayList<>();

        for (CityDto cityFromDto : cities) {
            cityList.add(new City()
                    .setCode(cityFromDto.getCode())
                    .setName(cityFromDto.getName()));
        }
        return cityList;
    }
}
