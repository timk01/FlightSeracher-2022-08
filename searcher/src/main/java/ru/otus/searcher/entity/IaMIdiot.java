package ru.otus.searcher.entity;

import dto.SearchResultDto;

import java.util.ArrayList;
import java.util.List;

public class IaMIdiot {
    public static void main(String[] args) {
        City city = new City();
        city.setCode("ABC");

        List<City> aCityList = new ArrayList<>();

        aCityList.add(city);

        city.setCode("DEF");
        aCityList.add(city);

        System.out.println(aCityList);

        changeValue(city);
        System.out.println(city.getCode());

        //second try

        SearchResultDto resultDTO = new SearchResultDto();

        List<SearchResultDto> aCityList2 = new ArrayList<>();
        aCityList2.add(resultDTO.builder().departCity("kukuevo").build());

        aCityList2.add(resultDTO.builder().departCity("kukuevo2").build());
        System.out.println(aCityList2.get(0).getDepartCity() + " " + aCityList2.get(1).getDepartCity());
    }

    public static void changeValue(City city) {
        city.setCode("123");
    }
}
