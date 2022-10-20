package com.example.searcher.dtos;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class SearchResultDtoList {
    private List<SearchResultDto> searchResultDtoList;
}
