package flightsearch;

import flightsearch.controllers.CountrySearchController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URISyntaxException;

@SpringBootApplication
public class SearcherApplication {

    public static void main(String[] args) throws URISyntaxException {

        SpringApplication.run(SearcherApplication.class, args);


    }

}
