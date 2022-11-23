package ru.otus.searcher.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Country {

    @Id
    private String code;

    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> cities;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Airport> airports;
}
