package com.example.searcher.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto {
    private String code;
    private String name;
    private String currency;

    @Override
    public String toString() {
        return "CountryDto{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
