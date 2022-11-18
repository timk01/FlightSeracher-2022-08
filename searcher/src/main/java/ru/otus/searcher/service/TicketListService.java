package ru.otus.searcher.service;

import DTO.SearchRequestDto;
import DTO.SearchResultDtoList;

public interface TicketListService {
    SearchResultDtoList getDtoTicketList(SearchRequestDto dto);
}
