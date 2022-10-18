package com.example.searcher.dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class SearchResultDto {
    private String departCity;
    private String arriveCity;
    private String site;
    private float price;
    private LocalDate localDateTime;
    private LocalDate departDate;
    private LocalDate returnDate;
    private int numberOfChanges;
    private long duration;
    private long distance;
}
