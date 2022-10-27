package ru.otus.flightsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import ru.otus.flightsearch.model.CountryListModel;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BotApplication {
    public static void main(String[] args) {

        SpringApplication.run(BotApplication.class, args);
    }
}
