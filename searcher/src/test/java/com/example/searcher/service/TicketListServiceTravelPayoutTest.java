package com.example.searcher.service;

import com.example.searcher.dtos.SearchResultDtoList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
class TicketListServiceTravelPayoutTest {

    @Autowired
    private TicketListServiceTravelPayout ticketListServiceTravelPayout;

    @BeforeEach
    void before() {
        //todo read file (test) return string
        //string --> SearchResultDtoList (Objmapper)
        //save to SearchResultDtoList (as field in test class)
    }

    @Test
    void getDtoTicketList() {
        SearchResultDtoList actualTicketList = ticketListServiceTravelPayout.getDtoTicketList();

        Assertions.assertNotNull(actualTicketList);
        //Assertions.assertEquals(); //look: before, actualTicketList
    }
}