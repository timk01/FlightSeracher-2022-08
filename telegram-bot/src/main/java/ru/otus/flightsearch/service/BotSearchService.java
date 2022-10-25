package ru.otus.flightsearch.service;

import common_dto.SearchRequestDto;
import common_dto.SearchResultDtoList;

public interface BotSearchService {
    SearchResultDtoList getDtoTicketList(SearchRequestDto dto);
}
