package ru.otus.buyer.model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private boolean isBot;

    private String lastName;

    private String userName;
}

/*public record Buyer(@Id Long id, String firstName, boolean isBot, String lastName, String userName) {
}*/

