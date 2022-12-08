package ru.otus.flightsearch.service;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import org.springframework.stereotype.Service;

@Service
public interface BotSearchService {
    SearchResultDtoList getDtoTicketList(SearchRequestDto dto);
}
