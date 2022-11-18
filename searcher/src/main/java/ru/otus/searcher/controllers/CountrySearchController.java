package ru.otus.searcher.controllers;

import dto.CountryDto;
import ru.otus.searcher.service.CountrySearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
