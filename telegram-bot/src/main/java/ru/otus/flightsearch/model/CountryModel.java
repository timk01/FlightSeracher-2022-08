package ru.otus.flightsearch.model;

import lombok.Data;
import org.springframework.jdbc.core.SqlReturnType;


@Data
public class CountryModel {
    private String code;
    private String name;
    private String currency;

    public CountryModel(String code, String name, String currency) {
        this.code = code;
        this.name = name;
        this.currency = currency;
    }
}
