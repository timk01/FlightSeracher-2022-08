package ru.otus.flightsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class SearchRequestDto {
    private String origin;
    private String destination;
    private Calendar date;
}
