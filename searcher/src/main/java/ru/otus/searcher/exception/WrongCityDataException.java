package ru.otus.searcher.exception;

public class WrongCityDataException extends RuntimeException {
    public WrongCityDataException(String message) {
        super(message);
    }
}