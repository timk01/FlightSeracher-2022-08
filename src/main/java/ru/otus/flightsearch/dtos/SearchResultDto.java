package ru.otus.flightsearch.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SearchResultDto {
    String departCity;
    String departAirPort;
    String arriveCity;
    String arriveAirPort;
    String airCompany;
    float price;
    LocalDateTime localDateTime;
}
