package ru.otus.searcher.controllers;


import dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.searcher.service.CitiesSearchService;

import java.util.List;

@RestController
@RequestMapping("api/cities")
@RequiredArgsConstructor
public class CitiesSearchController {
    private final CitiesSearchService citiesSearchService;

    @GetMapping
    public List<CityDto> getListOfCities(){
        return citiesSearchService.getCities();
    }
}
