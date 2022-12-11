package ru.otus.searcher.controllers;

import dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.searcher.service.CountrySearchService;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@RequiredArgsConstructor

public class CountrySearchController {

    private final CountrySearchService countrySearchService;

    @GetMapping
    public List<CountryDto> getCountries() {

        return countrySearchService.getCountry();
    }
}
