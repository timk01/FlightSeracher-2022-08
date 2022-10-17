package com.example.searcher.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Ticket {
    private long value;
    private String trip_class;
    private String origin;
    private String destination;
    private String gate;

    //@JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate depart_date;

    //@JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate return_date;

    private int number_of_changes;
    private LocalDate found_at;
    private long duration;
    private long distance;

    /*
    "value": 11610,
            "trip_class": 0,
            "show_to_affiliates": true,
            "origin": "MOW",
            "destination": "LON",
            "gate": "KupiBilet.ru",
            "depart_date": "2023-01-17",
            "return_date": "",
            "number_of_changes": 3,
            "found_at": "2022-10-15T07:57:14",
            "duration": 2065,
            "distance": 2443,
            "actual": true
     */
}
