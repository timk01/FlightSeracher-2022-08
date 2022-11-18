package com.example.searcher.controllers;

import com.example.searcher.service.CitiesSearchService;
import common_dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/city-search")
@RequiredArgsConstructor
public class CitiesSearchController {
    private final CitiesSearchService citiesSearchService;

    @GetMapping
    public List<CityDto> getListOfCities(){
        return citiesSearchService.getCities();
    }
}
