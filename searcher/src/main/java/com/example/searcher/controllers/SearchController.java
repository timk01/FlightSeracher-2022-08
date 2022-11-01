package com.example.searcher.controllers;

import com.example.searcher.service.TicketListService;
import common_dto.SearchRequestDto;
import common_dto.SearchResultDtoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/search")
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final TicketListService ticketListService;

    @PostMapping
    public SearchResultDtoList search(@RequestBody SearchRequestDto dto){

        return ticketListService.getDtoTicketList(dto);
    }
}