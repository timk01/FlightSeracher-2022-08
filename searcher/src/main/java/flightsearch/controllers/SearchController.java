package flightsearch.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import flightsearch.dtos.SearchResultDto;

import java.util.List;

@RequestMapping
@RestController
public class SearchController {
    @PostMapping
    public List<SearchResultDto> search(){
        return  List.of();
    }
}
