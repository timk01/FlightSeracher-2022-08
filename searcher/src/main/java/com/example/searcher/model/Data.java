package com.example.searcher.model;

import java.time.LocalDateTime;

@lombok.Data
public class Data {
    private long value;
    private String trip_class;
    private String origin;
    private String destination;
    private String gate;
    private String depart_date;
    private String return_date;
    private int number_of_changes;
    private LocalDateTime found_at;
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
