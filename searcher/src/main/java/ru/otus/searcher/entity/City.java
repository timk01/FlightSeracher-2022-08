package ru.otus.searcher.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class City {

    @Id
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "country_code")
    private Country country;

    @OneToMany(mappedBy = "cityOrigin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> ticketsOrigin;

    @OneToMany(mappedBy = "cityDestination", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> ticketsDestination;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Airport> airports;
}
