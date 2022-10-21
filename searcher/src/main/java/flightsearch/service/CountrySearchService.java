package flightsearch.service;

import flightsearch.dtos.CountryDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class CountrySearchService {
    public List<CountryDto> getCountry(){

        RestTemplate restTemplate = new RestTemplate();
        CountryDto[] responseArray;
        String url = "https://api.travelpayouts.com/aviasales_resources/v3/countries.json";

        try {
            responseArray = restTemplate.getForEntity(new URI(url),CountryDto[].class).getBody();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return List.of(responseArray);
    }
}
