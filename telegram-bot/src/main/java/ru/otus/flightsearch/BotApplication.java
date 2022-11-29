package ru.otus.flightsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.flightsearch.configuration.BotServiceProperties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties(value = BotServiceProperties.class)
public class BotApplication {
    public static void main(String[] args) {

        SpringApplication.run(BotApplication.class, args);
    }
}
