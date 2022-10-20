package ru.otus.flightsearch.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Data
@Slf4j
public class TicketRequest {
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    private final String origin;
    private final String destination;
    private final Calendar date;

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
        final Calendar paramDate;

        validateCity(paramsArray[0]);
        validateCity(paramsArray[1]);
        paramDate = parseDate(paramsArray[2], paramsArray[3], paramsArray.length > 4 ? paramsArray[4] : null);
        validateDate(paramDate);

        return new TicketRequest(paramsArray[0], paramsArray[1], paramDate);
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
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.add(Calendar.DAY_OF_MONTH, -1);
        if (calendarNow.compareTo(calendarEntered) > 0) {
            throw new IllegalArgumentException("The date must be today or in future");
        }
    }

    private static Integer getMonthFromString(String month) {
        DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMMM", new Locale("ru"));
        return monthFormat.parse(month).get(ChronoField.MONTH_OF_YEAR) - 1;
    }


}