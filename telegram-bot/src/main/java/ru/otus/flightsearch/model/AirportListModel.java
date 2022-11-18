package ru.otus.flightsearch.model;

import com.google.common.collect.Lists;
import common_dto.AirportDto;
import lombok.Data;
import org.springframework.ui.Model;
import ru.otus.flightsearch.service.BotServiceAirports;

import java.util.List;
@Data
public class AirportListModel {
    private final List<AirportDto> listOfAirports;

    public AirportListModel(AirportDto[] array) {

        this.listOfAirports = Lists.newArrayList(array);
    }
}
