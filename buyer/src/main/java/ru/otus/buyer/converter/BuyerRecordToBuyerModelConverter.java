package ru.otus.buyer.converter;

import dto.BuyerRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.buyer.model.Buyer;

@Component
public class BuyerRecordToBuyerModelConverter implements Converter<BuyerRecord, Buyer> {

    @Override
    public Buyer convert(BuyerRecord buyerRecord) {
        return new Buyer()
                .setId(buyerRecord.id())
                .setFirstName(buyerRecord.firstName())
                .setBot(buyerRecord.isBot())
                .setLastName(buyerRecord.lastName())
                .setUserName(buyerRecord.userName())
                ;
    }
}