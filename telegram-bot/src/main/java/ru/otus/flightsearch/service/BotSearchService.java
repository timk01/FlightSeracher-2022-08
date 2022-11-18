package ru.otus.flightsearch.service;

import DTO.SearchRequestDto;
import DTO.SearchResultDtoList;

public interface BotSearchService {
    SearchResultDtoList getDtoTicketList(SearchRequestDto dto);
}
