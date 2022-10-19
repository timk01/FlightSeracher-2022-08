package ru.otus.flightsearch.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.*;

@Data
@Slf4j
public class TicketRequest {
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    private final String origin;
    private final String destination;
    private final Calendar date;
    private final String error;

    private static Set<String> citiesSet = new HashSet<>() {{
        add("уфа");
        add("санкт-петербург");
        add("казань");
        add("москва");
        add("екатеринбург");
        add("самара");
        add("ижевск");
        add("стерлитамак");
        add("нью-йорк");
        add("нижний новгород");
        add("учалы");
        add("дубай");
    }};

    public static TicketRequest ofText(String text) {
        final String[] paramsArray = text.split(" ");
        final Calendar paramDate;
        try {
            validateCity(paramsArray[0]);
            validateCity(paramsArray[1]);
            paramDate = parseDate(paramsArray[2], paramsArray[3], paramsArray.length > 4 ? paramsArray[4] : null);
            validateDate(paramDate);
        } catch (ParseException | IllegalArgumentException e) {
            return new TicketRequest(null, null, null, e.getMessage());
        }
        return new TicketRequest(paramsArray[0], paramsArray[1], paramDate, null);
    }

    private static Calendar parseDate(String day, String month, String year) throws ParseException {
        Integer yearInt = getYearFromString(year);
        Integer monthInt = getMonthFromString(month);
        Integer dayInt = Integer.parseInt(day);

        Calendar calendarFromString = Calendar.getInstance();
        calendarFromString.setLenient(Boolean.FALSE);
        calendarFromString.set(yearInt, monthInt, dayInt);

        try {
            log.info("date From String : " + calendarFromString.getTime());
        } catch (IllegalArgumentException e) {
            log.error("You are entering wrong date");
            throw e;
        }

        return calendarFromString;
    }

    private static Integer getYearFromString(String year) {
        if (year == null) {
            return Calendar.getInstance().get(Calendar.YEAR);
        } else {
            return Integer.parseInt(year);
        }
    }

    private static void validateCity(String city) {
        if (!citiesSet.contains(city.toLowerCase()))
            throw new IllegalArgumentException("You are entering wrong city: " + city);
    }

    private static void validateDate(Calendar calendarEntered) {
        if (Calendar.getInstance().compareTo(calendarEntered) == 1) {
            throw new IllegalArgumentException("The date must be today or in future");
        }
    }

    private static Integer getMonthFromString(String month) {
        DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMMM", new Locale("ru"));
        return monthFormat.parse(month).get(ChronoField.MONTH_OF_YEAR) - 1;
    }
}