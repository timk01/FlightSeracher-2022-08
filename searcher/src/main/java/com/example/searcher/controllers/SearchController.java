package com.example.searcher.controllers;

import com.example.searcher.dtos.SearchResultDtoList;
import com.example.searcher.service.TicketListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.searcher.dtos.SearchResultDto;

import java.util.List;

@RequestMapping("api/search")
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final TicketListService ticketListService;

    @GetMapping
    public SearchResultDtoList search(){
        return ticketListService.getDtoTicketList();
    }
}
