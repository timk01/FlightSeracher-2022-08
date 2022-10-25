package ru.otus.flightsearch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.otus.flightsearch.component.FlightSearcherBot;

@Slf4j
@Component
public class BotInitializer {
    private final FlightSearcherBot bot;

    public BotInitializer(FlightSearcherBot bot) {
        this.bot = bot;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);
            log.info("Flight Searcher bot started");
        } catch (TelegramApiException e) {
            log.error("Error during initialize bot", e);
        }
    }
}
