package ru.otus.searcher.controllers;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.searcher.exception.WrongCityDataException;
import ru.otus.searcher.service.TicketListService;

@RequestMapping("api/tickets")
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final TicketListService ticketListService;

    @PostMapping
    public SearchResultDtoList search(@RequestBody SearchRequestDto dto) {

        return ticketListService.getDtoTicketList(dto);
    }

    //localhost:8082/api/tickets > <

    @ExceptionHandler(WrongCityDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleNoSuchElementFoundException(
            WrongCityDataException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}