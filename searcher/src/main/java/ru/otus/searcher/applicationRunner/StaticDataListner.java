package ru.otus.searcher.applicationRunner;

import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class StaticDataListner    {
    private final CityLoadingService cityLoadingService;
    private final CountryLoadingService countryLoadingService;
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        cityLoadingService.load();
        countryLoadingService.load();

    }
}
