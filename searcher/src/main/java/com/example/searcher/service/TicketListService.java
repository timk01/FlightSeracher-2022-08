package com.example.searcher.service;

import com.example.searcher.model.Data;
import com.example.searcher.model.Data2;

import java.util.List;

public interface TicketListService {
    Data2 getTicketList();
    List<Data> getTicketListRoughImpl();
}
