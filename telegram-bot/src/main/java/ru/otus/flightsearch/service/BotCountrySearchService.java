package ru.otus.flightsearch.service;


import ru.otus.flightsearch.model.CountryListModel;

import java.util.List;

public interface BotCountrySearchService {
    CountryListModel obtainCountriesList();
}
