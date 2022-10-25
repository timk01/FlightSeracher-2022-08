package ru.otus.flightsearch.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.otus.flightsearch.configuration.BotConfig;
import ru.otus.flightsearch.converter.TickerRequestToSearchRequestDtoConverter;
import ru.otus.flightsearch.model.TicketRequest;
import ru.otus.flightsearch.service.BotSearchService;

@Slf4j
@Component
@RequiredArgsConstructor
public class FlightSearcherBot extends TelegramLongPollingBot {
    private final BotConfig config;
    private final BotSearchService botSearchService;
    private final ObjectMapper objectMapper;

    @Override
    //@SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            TicketRequest ticketRequest = null;
            String messageText;
            try {
                ticketRequest = TicketRequest.ofText(update.getMessage().getText());
            } catch (IllegalArgumentException e) {
                messageText = "You entered a wrong date";
            } catch (Exception e) {
                messageText = e.getMessage();
            }

            long chatId = update.getMessage().getChatId();
            try {
                sendMessage(chatId,
                        objectMapper.
                                writeValueAsString(
                                        botSearchService
                                        .getDtoTicketList(
                                                TickerRequestToSearchRequestDtoConverter
                                                        .convert(ticketRequest))));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }


    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error during register bot", e);
        }
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }
}
