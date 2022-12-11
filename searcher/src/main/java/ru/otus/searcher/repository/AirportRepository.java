package ru.otus.searcher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.searcher.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
}
