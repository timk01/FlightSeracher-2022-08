package ru.otus.buyer.controller;

import dto.BuyerRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.buyer.service.BuyerService;

@RestController
@RequestMapping("api/buyers/info/save")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @PostMapping
    public void saveUserData(@RequestBody BuyerRecord buyerRecord) {

        buyerService.saveUserInfo(buyerRecord);
    }
}
