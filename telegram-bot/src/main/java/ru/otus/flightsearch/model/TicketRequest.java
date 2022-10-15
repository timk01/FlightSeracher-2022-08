package ru.otus.flightsearch.model;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class TicketRequest {
    private final String origin;
    private final String destination;
    private final Date date;
    private final String error;
    private static Map<String, Integer> monthsMap = new HashMap<>() {{
        put("января", 1);
        put("февраля", 2);
        put("марта", 3);
        put("апреля", 4);
        put("мая", 5);
        put("июня", 6);
        put("июля", 7);
        put("августа", 8);
        put("сентября", 9);
        put("октября", 10);
        put("ноября", 11);
        put("декабря", 12);
    }};

    public static TicketRequest ofText(String text) {
        final String[] paramsArray = text.split(" ");
        final Date paramDate;
        try {
            paramDate = parseDate(paramsArray[2], paramsArray[3]);
        } catch (ParseException e) {
            return new TicketRequest(null, null, null, e.getMessage());
        }
        return new TicketRequest(paramsArray[0], paramsArray[1], paramDate, null);

    }

    private static Date parseDate(String day, String month) throws ParseException {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date parsedDate;

            parsedDate = formatter.parse(String.format("%s-%s-%s", day, monthsMap.get(month.toLowerCase()), year));
        return parsedDate;
    }
}


