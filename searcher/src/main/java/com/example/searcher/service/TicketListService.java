package com.example.searcher.service;

import common_dto.SearchRequestDto;
import common_dto.SearchResultDtoList;

public interface TicketListService {
    SearchResultDtoList getDtoTicketList(SearchRequestDto dto);
}
