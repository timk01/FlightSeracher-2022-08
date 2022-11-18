package DTO;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SearchResultDtoList {
    private List<SearchResultDto> searchResultDtoList;
}
