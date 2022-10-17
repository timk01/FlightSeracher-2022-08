package com.example.searcher.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

@lombok.Data
public class Data2 {
    private boolean success;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Data2> ticketList;

}
