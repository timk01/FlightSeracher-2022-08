package ru.otus.flightsearch.service;

import dto.BuyerRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.flightsearch.configuration.BotServiceProperties;

@Service
@Slf4j
public class BotBuyerService {

    private final RestTemplate restTemplate;
    private final URIBuilder builder;

    @Autowired
    public BotBuyerService(RestTemplate restTemplate, BotServiceProperties botServiceProperties) {
        this.restTemplate = restTemplate;
        this.builder = new URIBuilder()
                .setScheme("http")
                .setHost(botServiceProperties.getBuyerDataHost())
                .setPath(botServiceProperties.getBuyerDataPath());
    }

    public void postBuyerInfo(BuyerRecord buyerRecord) {
        BuyerRecord sendBuyerRecord = restTemplate.postForObject(builder.toString(), buyerRecord, BuyerRecord.class);
        if (sendBuyerRecord != null) {
            log.info("posted info: {}", sendBuyerRecord.id());
        }
    }
}
