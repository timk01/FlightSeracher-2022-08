package ru.otus.flightsearch.exception;

public class WrongCityDataException extends RuntimeException {
    public WrongCityDataException(String message) {
        super(message);
    }
}