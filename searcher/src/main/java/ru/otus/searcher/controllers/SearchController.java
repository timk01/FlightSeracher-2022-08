package ru.otus.searcher.controllers;

import ru.otus.searcher.service.TicketListService;
import DTO.SearchRequestDto;
import DTO.SearchResultDtoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/tickets")
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final TicketListService ticketListService;

    @PostMapping
    public SearchResultDtoList search(@RequestBody SearchRequestDto dto){

        return ticketListService.getDtoTicketList(dto);
    }
}