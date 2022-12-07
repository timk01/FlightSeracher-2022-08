package ru.otus.searcher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.searcher.entity.City;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    Optional<City> findCityByName(String name);
}
