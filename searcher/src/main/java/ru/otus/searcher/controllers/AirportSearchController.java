package ru.otus.searcher.controllers;

import dto.AirportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.searcher.service.AirportsSearchService;

import java.util.List;

@RestController
@RequestMapping("api/airports")
@RequiredArgsConstructor
public class AirportSearchController {
    private final AirportsSearchService airportsSearchService;

    @GetMapping
    public List<AirportDto> getAirports(){

        return airportsSearchService.getAirports();
    }
}
