package flightsearch.controllers;

import flightsearch.dtos.CountryDto;
import flightsearch.service.CountrySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/countrysearch")
public class CountrySearchController {
    @Autowired
    private CountrySearchService countrySearchService;

    @GetMapping
    public List<CountryDto> getCountries() {
        return countrySearchService.getCountry();
    }
}
