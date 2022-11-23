package ru.otus.searcher.converter;

import dto.SearchResultDto;
import dto.SearchResultDtoList;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.searcher.model.Ticket;
import ru.otus.searcher.model.TicketSearchResult;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketSearchResultToSearchResultDTOConverter implements Converter<TicketSearchResult, SearchResultDtoList> {

    @Override
    public SearchResultDtoList convert(TicketSearchResult result) {

        List<SearchResultDto> searchResultDtoList = new ArrayList<>();

        for (Ticket actualTicket : result.getData()) {
            SearchResultDto resultDto = SearchResultDto
                    .builder()
                    .departCity(actualTicket.getOrigin())
                    .arriveCity(actualTicket.getDestination())
                    .site(actualTicket.getGate())
                    .price(actualTicket.getValue())
                    .departDate(actualTicket.getDepartDate())
                    .returnDate(actualTicket.getReturnDate())
                    .numberOfChanges(actualTicket.getNumberOfChanges())
                    .duration(actualTicket.getDuration())
                    .distance(actualTicket.getDistance())
                    .build();
            searchResultDtoList.add(resultDto);
        }

        return new SearchResultDtoList(searchResultDtoList);
    }
}
