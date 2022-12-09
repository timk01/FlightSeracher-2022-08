package ru.otus.flightsearch.service;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import ru.otus.flightsearch.exception.WrongCityDataException;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
@Slf4j
public class MockErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() != HttpStatus.OK) {
            log.debug("Status code: " + response.getStatusCode());
            log.debug("Response" + response.getStatusText());
            log.debug(String.valueOf(response.getBody()));

            if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
                log.debug("Call returned a error 400 forbidden response ");
                return true;
            }
        }
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
            log.debug(HttpStatus.FORBIDDEN + " response. Throwing authentication exception");
            throw new RuntimeException("Cannot get data due to wrong city name22222222222222222222222");
        }
    }
}
