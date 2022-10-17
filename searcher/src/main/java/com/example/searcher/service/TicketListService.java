package com.example.searcher.service;

import com.example.searcher.model.Ticket;
import flightsearch.dtos.SearchResultDto;
import flightsearch.dtos.SearchResultDtoList;

import java.util.List;

public interface TicketListService {
    SearchResultDtoList getDtoTicketList();
    List<Ticket> getTicketListRoughImpl();
}
