package ru.otus.flightsearch.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import DTO.AirportDto;
import DTO.CountryDto;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
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
import ru.otus.flightsearch.service.BotServiceAirports;
import ru.otus.flightsearch.service.BotServiceCountries;

import java.text.ParseException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class FlightSearcherBot extends TelegramLongPollingBot {
    private final BotConfig config;
    private final BotSearchService botSearchService;

    private final BotServiceCountries botServiceCountries;
    private final BotServiceAirports botServiceAirports;
    private final ObjectMapper objectMapper;

    private static final String SHOW_COUNTRIES = "покажи список стран";
    private static final String SHOW_TICKETS = "покажи билеты";

    private static final String SHOW_AIRPORTS = "покажи аэропорты";

    private static final String SHOW_CITIES= "покажи города";

    @Override
    //@SneakyThrows
    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().hasText()) {
            String inputMessage = update.getMessage().getText();

            if (inputMessage.startsWith(SHOW_TICKETS)) {
                processTicketRequest(update);
            } else if (inputMessage.equals(SHOW_COUNTRIES)) {
                processCountryRequest(update);
            } else if (inputMessage.equals(SHOW_AIRPORTS)){
                processAirportRequest(update);
            }

        }
    }

    private void processAirportRequest(Update update) {
        long chatId = update.getMessage().getChatId();
        sendAirportList(chatId, Lists.newArrayList(botServiceAirports.getAirports()));

    }

    private void sendAirportList(long chatId, List<AirportDto> dtoList) {
        List<AirportDto> arrCopy = dtoList;


        int n = 20; //количество объектов которое мы хотим передать из массива в sendMessage
        int g = (int) Math.ceil((1.0*arrCopy.size())/n);

        String country;

        for (int y = 0; y < g; y++) {
            StringBuilder stringBuilder = new StringBuilder();
            int counter = 0;
            while (counter < n) {
                if(arrCopy.isEmpty()) {
                    break;
                }
                stringBuilder.append(arrCopy.get(0).getCode()).append("\n");
                arrCopy.remove(0);
                counter++;
            }

            country = stringBuilder.toString();
            log.info(country);
            sendMessage(chatId, country);
        }
    }

    private void processCountryRequest(Update update) {

        long chatId = update.getMessage().getChatId();
            sendCountryList(chatId, Lists.newArrayList(botServiceCountries.obtainCountriesList()));

    }

    private void sendCountryList(long chatId, List<CountryDto> countryDtoList) {

        List<CountryDto> arrCopy = countryDtoList;

        int n = 20;
        int g = (int) Math.ceil((1.0*arrCopy.size())/n);


        for (int y = 0; y < g; y++) {
            StringBuilder stringBuilder = new StringBuilder();

            int counter = 0;
            while (counter < n) {
                if(arrCopy.isEmpty()) {
                    break;
                }
                stringBuilder.append(arrCopy.get(0).getName()).append("\n");
                arrCopy.remove(0);
                counter++;
            }

            log.info(stringBuilder.toString());
            sendMessage(chatId, stringBuilder.toString());
        }
    }

    private void processTicketRequest(Update update) {

        TicketRequest ticketRequest = null;

        String messageTextWithOutPrefix = update.getMessage().getText().replace(SHOW_TICKETS,"");

        try {
            ticketRequest = TicketRequest.ofText(messageTextWithOutPrefix.trim());
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
