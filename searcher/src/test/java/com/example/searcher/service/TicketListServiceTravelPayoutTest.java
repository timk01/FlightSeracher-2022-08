package com.example.searcher.service;

import common_dto.SearchRequestDto;
import common_dto.SearchResultDtoList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
class TicketListServiceTravelPayoutTest {

    @Autowired
    private TicketListServiceTravelPayout ticketListServiceTravelPayout;

    private SearchRequestDto dto;

    @BeforeEach
    void before() {
       /*dto = SearchRequestDto
                .builder()
                .origin("MOS")
                .destination("LON")
                .date(LocalDateTime.now())
                .build();*/
        //todo read file (test) return string
        //string --> SearchResultDtoList (Objmapper)
        //save to SearchResultDtoList (as field in test class)
    }

    @Test
    void getDtoTicketList() {
        SearchResultDtoList actualTicketList = ticketListServiceTravelPayout
                .getDtoTicketList(dto);

        Assertions.assertNotNull(actualTicketList);
        //Assertions.assertEquals(); //look: before, actualTicketList
    }

/*    @Test
    void getDtoTicketList(SearchRequestDto dto) {
        SearchResultDtoList actualTicketList = ticketListServiceTravelPayout
                .getDtoTicketList(dto);

        Assertions.assertNotNull(actualTicketList);
        //Assertions.assertEquals(); //look: before, actualTicketList
    }*/
}