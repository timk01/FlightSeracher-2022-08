package ru.otus.searcher.controllers;

import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.searcher.exception.CustomException;
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

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(
            CustomException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}