package ru.otus.searcher.controllers;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.searcher.service.TicketListService;

@RequestMapping("api/tickets")
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final TicketListService ticketListService;

    @PostMapping
    public SearchResultDtoList search(@RequestBody SearchRequestDto dto) {

        return ticketListService.getDtoTicketList(dto);
    }
}