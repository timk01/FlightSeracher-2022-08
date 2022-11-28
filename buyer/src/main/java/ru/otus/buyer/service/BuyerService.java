package ru.otus.buyer.service;

import dto.BuyerRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.buyer.repository.BuyerRepository;

@Service
@RequiredArgsConstructor
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public void saveUserInfo(BuyerRecord record) {
        //buyerRepository.save(record);
    }
}
