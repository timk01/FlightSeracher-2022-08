package ru.otus.searcher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.searcher.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
