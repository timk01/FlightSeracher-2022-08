package com.example.searcher.controllers;

import com.example.searcher.service.CountrySearchService;
import common_dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/country-search")
@RequiredArgsConstructor
public class CountrySearchController {

    private final CountrySearchService countrySearchService;

    @GetMapping
    public List<CountryDto> getCountries() {
        return countrySearchService.getCountry();
    }
}
