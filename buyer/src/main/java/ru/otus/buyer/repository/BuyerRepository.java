package ru.otus.buyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.buyer.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
