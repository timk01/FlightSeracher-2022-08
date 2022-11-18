package ru.otus.searcher.applicationRunner;

import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.otus.searcher.repository.CityRepository;

@Component
@AllArgsConstructor
public class CityLoadingServiceListener {

    private final CityRepository cityRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        CityLoadingService cityLoadingService = event.getApplicationContext().getBean(CityLoadingService.class);
        cityLoadingService.load();
    }
}
