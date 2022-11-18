package ru.otus.searcher.applicationRunner;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityDataBaseFiller {

    private final ApplicationEventPublisher eventPublisher;

    public void publishMsgEvent(String msg) {
        eventPublisher.publishEvent(msg);
    }
}
