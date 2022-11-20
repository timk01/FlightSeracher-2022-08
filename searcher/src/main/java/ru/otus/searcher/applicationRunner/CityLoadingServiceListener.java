package ru.otus.searcher.applicationRunner;

import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CityLoadingServiceListener {

    private final CityLoadingService cityLoadingService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        cityLoadingService.load();
    }
}
