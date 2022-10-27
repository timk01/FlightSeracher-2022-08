package ru.otus.flightsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import common_dto.CountryDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Data
public class CountryListModel {

    @JsonFormat
    private final List<CountryDto> listOfCountries;
}
