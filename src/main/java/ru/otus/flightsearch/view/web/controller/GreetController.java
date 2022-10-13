package ru.otus.flightsearch.view.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}