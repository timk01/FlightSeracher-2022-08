package com.example.searcher.service;

import com.example.searcher.model.Ticket;
import com.example.searcher.dtos.SearchResultDtoList;

import java.util.List;

public interface TicketListService {
    SearchResultDtoList getDtoTicketList();
}
