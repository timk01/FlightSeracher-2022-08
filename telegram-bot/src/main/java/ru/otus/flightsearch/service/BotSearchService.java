package ru.otus.flightsearch.service;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;

public interface BotSearchService {
    SearchResultDtoList getDtoTicketList(SearchRequestDto dto);
}
