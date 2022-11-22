package ru.otus.searcher.applicationRunner;

import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AirportLoadingServiceListener {

    private final AirportLoadingService airportLoadingService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        airportLoadingService.load();
    }
}
