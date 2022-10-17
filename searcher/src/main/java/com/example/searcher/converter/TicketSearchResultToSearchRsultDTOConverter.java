package com.example.searcher.converter;

import com.example.searcher.model.Ticket;
import com.example.searcher.model.TicketSearchResult;
import flightsearch.dtos.SearchResultDto;
import flightsearch.dtos.SearchResultDtoList;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

//@Component
@UtilityClass
public class TicketSearchResultToSearchRsultDTOConverter {
    public SearchResultDtoList convert(TicketSearchResult result) {
        List<SearchResultDto> searchResultDtoList = new ArrayList<>();
        for (Ticket actualTicket : result.getData()) {
            SearchResultDto resultDto = SearchResultDto
                    .builder()
                    .departCity(actualTicket.getOrigin())
                    .arriveCity(actualTicket.getDestination())
                    .site(actualTicket.getGate())
                    .price(actualTicket.getValue())
                    .localDateTime(actualTicket.getFound_at())
                    .departDate(actualTicket.getDepart_date())
                    .returnDate(actualTicket.getReturn_date())
                    .numberOfChanges(actualTicket.getNumber_of_changes())
                    .duration(actualTicket.getDuration())
                    .distance(actualTicket.getDistance())
                    .build();
            searchResultDtoList.add(resultDto);
        }
        return new SearchResultDtoList(searchResultDtoList);
    }
}
