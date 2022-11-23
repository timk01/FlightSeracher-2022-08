package ru.otus.flightsearch.converter;

import dto.SearchRequestDto;
import lombok.experimental.UtilityClass;
import ru.otus.flightsearch.model.TicketRequest;

@UtilityClass
public class TickerRequestToSearchRequestDtoConverter {

    public SearchRequestDto convert(TicketRequest request) {
        return SearchRequestDto
                .builder()
                .origin(request.getOrigin())
                .destination(request.getDestination())
                .date(request.getActualDate())
                .build();
    }
}
