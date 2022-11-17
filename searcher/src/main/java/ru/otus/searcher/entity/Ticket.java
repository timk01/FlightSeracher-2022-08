package ru.otus.searcher.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "origin")
    private City cityOrigin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "destination")
    private City cityDestination;
}
