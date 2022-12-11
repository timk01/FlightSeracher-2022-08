package ru.otus.searcher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.searcher.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
