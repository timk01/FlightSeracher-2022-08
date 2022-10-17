package com.example.searcher;

import com.example.searcher.model.TicketSearchResult;
import com.example.searcher.service.TicketListService;
import com.example.searcher.service.Token;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import flightsearch.dtos.SearchResultDto;
import flightsearch.dtos.SearchResultDtoList;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootApplication
public class SearcherApplication {

    static String URIBuilderString = (new URIBuilder()
            .setScheme("https")
            .setHost("api.travelpayouts.com")
            .setPath("/v2/prices/latest")
            .addParameter("origin", "MOW")
            .addParameter("destination", "LON")
            .addParameter("sorting", "price")
            .addParameter("trip_class", "0")
            .addParameter("currency", "rub")
            .addParameter("limit", "30")
            .addParameter("page", "1")
            .addParameter("token", Token.secretToken)).toString();

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //SpringApplication.run(SearcherApplication.class, args);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SearcherApplication.class);

        TicketListService service = applicationContext.getBean(TicketListService.class);

        System.out.println("Getting list of all tickets:");

        SearchResultDtoList dtoTicketList = service.getDtoTicketList();
        dtoTicketList.getSearchResultDtoList().stream().forEach(System.out::println);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        //objectMapper.writerWithDefaultPrettyPrinter();
        //objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        String json = objectMapper.writeValueAsString(dtoTicketList);
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());

        //service.getTicketListRoughImpl();

        //"https://api.travelpayouts.com/v2/prices/latest?origin=MOW&destination=LON&one_way=true&sorting=price&trip_class=0&currency=rub&limit=30&page=1&token=fc51222b5efbb95d3343a569c47f6c84"

       /* HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(
                        new URI
                                (
                                        URIBuilderString
                                )
                )
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(getResponse.body());*/

    }
}
