package ru.otus.searcher.applicationRunner;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CountryLoadingListener {
    private final CountryLoadingService countryLoadingService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        countryLoadingService.load();
    }


}