package ru.otus.flightsearch.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.BuyerRecord;
import dto.SearchRequestDto;
import dto.SearchResultDtoList;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BotBuyerService {

    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public BotBuyerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("api/buyers/info/save");
    }

    public void postBuyerInfo(BuyerRecord buyerRecord) {
        BuyerRecord sendBuyerRecord = restTemplate.postForObject(builder.toString(), buyerRecord, BuyerRecord.class);
        if (sendBuyerRecord != null) {
            log.info("posted info: {}", sendBuyerRecord.id());
        }
    }
}
