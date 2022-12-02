package ru.otus.flightsearch.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;

@Data
@Slf4j
public class TicketRequest {
    public static final String europeanDatePattern = "dd-MM-yyyy";

    private final String origin;
    private final String destination;
    private final LocalDate actualDate;

    private static Set<String> citiesSet = new HashSet<>() {{
        add("уфа");
        add("санкт-петербург");
        add("казань");
        add("москва");
        add("екатеринбург");
        add("самара");
        add("нью-йорк");
        add("дубай");
    }};

    public static TicketRequest ofText(String text) throws ParseException {
        final String[] paramsArray = text.split(" ");

        return new TicketRequest(paramsArray[0]
                , paramsArray[1]
                , parseDateAndConvertToLocalDateTime(paramsArray[2]));
    }

    public static LocalDate parseDateAndConvertToLocalDateTime(String dateStr) {
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(europeanDatePattern));
        } catch (DateTimeParseException e) {
            log.error("You are entering wrong formatted date");
            return null;
        }
        return parsedDate;
    }


}