package ru.otus.flightsearch.controller;

import com.example.searcher.dtos.SearchResultDtoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.flightsearch.dto.SearchRequestDto;
import ru.otus.flightsearch.service.BotSearchService;

@RequestMapping("bot-service/api")
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final BotSearchService botSearchService;

    @PostMapping
    public SearchResultDtoList search(@RequestBody SearchRequestDto SearchRequestDto){
        return null; //botSearchService.getDtoTicketList();
    }
}
