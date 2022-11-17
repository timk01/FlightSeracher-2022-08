package com.example.searcher.controllers;

import com.example.searcher.service.CitiesSearchService;
import common_dto.CitiesDto;
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
    public List<CitiesDto> getListOfCities(){
        return citiesSearchService.getCities();
    }
}
