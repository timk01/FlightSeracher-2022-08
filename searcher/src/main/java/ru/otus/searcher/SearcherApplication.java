package ru.otus.searcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.searcher.configuration.TravelPayoutProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = TravelPayoutProperties.class)
public class SearcherApplication {

    public static void main(String[] args) {

        SpringApplication.run(SearcherApplication.class, args);
    }
}
