package ru.otus.searcher;

import ru.otus.searcher.configuration.TravelPayoutProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = TravelPayoutProperties.class)
public class SearcherApplication {

    public static void main(String[] args) {

        SpringApplication.run(SearcherApplication.class, args);
    }
}
