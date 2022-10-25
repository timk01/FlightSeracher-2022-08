package ru.otus.flightsearch.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.*;

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

        validateCity(paramsArray[0]);
        validateCity(paramsArray[1]);

        return new TicketRequest(paramsArray[0]
                , paramsArray[1]
                , parseDateAndConvertToLocalDateTime(paramsArray[2]));
    }

    public static LocalDate parseDateAndConvertToLocalDateTime(String dateStr) {
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(europeanDatePattern));
        } catch (DateTimeParseException  e) {
            log.error("You are entering wrong formatted date");
            return null;
        }
        return parsedDate;
    }

    private static void validateCity(String city) {
        if (!citiesSet.contains(city.toLowerCase()))
            throw new IllegalArgumentException("You are entering wrong city: " + city);
    }
}