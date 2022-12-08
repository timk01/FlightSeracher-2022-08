package ru.otus.searcher.exception;

public class WrongCityDataException extends RuntimeException {
    public WrongCityDataException(Throwable cause) {
        super(cause);
    }

    public WrongCityDataException(String message) {
        super(message);
    }
}