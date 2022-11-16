package com.example.searcher.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "airport")
@Getter
@Setter
public class Airport {

    @Id
    @Column(name = "code")
    private String id;

    @Column(name = "iata_type")
    private String iataType;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "country_code")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "city_code")
    private City city;
}
