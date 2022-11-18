package com.example.searcher.controllers;

import com.example.searcher.service.AirportsSearchService;
import common_dto.AirportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/airport-search")
@RequiredArgsConstructor
public class AirportSearchController {
    private final AirportsSearchService airportsSearchService;

    @GetMapping
    public List<AirportDto> getAirports(){
        return airportsSearchService.getAirports();
    }
}
