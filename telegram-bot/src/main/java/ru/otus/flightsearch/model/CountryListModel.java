package ru.otus.flightsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import common_dto.CountryDto;
import lombok.Data;
import java.util.List;


@Data

public class CountryListModel {

    @JsonFormat
    private List<CountryDto> listOfCountries;

    public CountryListModel(CountryDto[] array){

        this.listOfCountries = Lists.newArrayList(array);
    }
}
