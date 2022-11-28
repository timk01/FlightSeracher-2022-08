package ru.otus.buyer.service;

import dto.BuyerRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.otus.buyer.model.Buyer;
import ru.otus.buyer.repository.BuyerRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BuyerService {

    private final BuyerRepository buyerRepository;
    private final Converter<BuyerRecord, Buyer> converter;

    public void saveUserInfo(BuyerRecord buyerRecord) {
            buyerRepository.save(Objects.requireNonNull(converter.convert(buyerRecord)));
    }
}
