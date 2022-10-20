package ru.otus.flightsearch.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.otus.flightsearch.config.BotConfig;
import ru.otus.flightsearch.model.TicketRequest;

@Slf4j
@Component
public class FlightSearcherBot extends TelegramLongPollingBot {
    private final BotConfig config;

    public FlightSearcherBot(BotConfig config) {
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            TicketRequest ticketRequest = null;
            String messageText;
            try {
                ticketRequest = TicketRequest.ofText(update.getMessage().getText());
                messageText = "Вы ищете билет из "
                        + ticketRequest.getOrigin()
                        + " в "
                        + ticketRequest.getDestination()
                        + " на "
                        + TicketRequest.formatter.format(ticketRequest.getDate().getTime());
            } catch (Exception e) {
                messageText = e.getMessage();
            }
            long chatId = update.getMessage().getChatId();
            sendMessage(chatId, messageText);
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
