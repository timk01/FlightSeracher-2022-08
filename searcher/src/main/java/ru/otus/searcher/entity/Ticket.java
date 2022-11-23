package ru.otus.searcher.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long price;

    private Timestamp departDate;

    private Integer numberOfChanges;

    private Long duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "origin")
    private City cityOrigin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "destination")
    private City cityDestination;
}
