package com.example.searcher.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryModel {
    private String country_code;
    private String code;
    private String name;
}
