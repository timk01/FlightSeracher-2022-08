package ru.otus.searcher.service;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;

public interface TicketListService {
    SearchResultDtoList getDtoTicketList(SearchRequestDto dto);
}
