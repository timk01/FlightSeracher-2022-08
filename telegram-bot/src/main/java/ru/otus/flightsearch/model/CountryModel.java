package ru.otus.flightsearch.model;

import lombok.Data;
import org.springframework.jdbc.core.SqlReturnType;


@Data
public class CountryModel {
    private String code;
    private String name;
    private String currency;
}
