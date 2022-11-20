package ru.otus.searcher.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class City {

    @Id
    private String code;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "country_code")
    private Country country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Airport> airports;
}
