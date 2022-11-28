package ru.otus.buyer.controller;

import dto.BuyerRecord;
import dto.SearchResultDtoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.buyer.service.BuyerService;

import java.util.List;

@RestController
@RequestMapping("api/buyers/info/save")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    public void saveUserData(@RequestBody BuyerRecord buyerRecord){

        buyerService.saveUserInfo(buyerRecord);
    }
}
