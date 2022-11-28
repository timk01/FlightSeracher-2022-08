package ru.otus.buyer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Buyer {

    @Id
    private Long id;

    private String firstName;

    private boolean isBot;

    private String lastName;

    private String userName;
}

