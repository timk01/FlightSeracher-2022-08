package com.example.searcher.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "origin")
    private City cityOrigin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "destination")
    private City cityDestination;
}
