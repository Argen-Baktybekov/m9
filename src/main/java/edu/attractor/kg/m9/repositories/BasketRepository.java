package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query("select b from Basket b where b.customer.email = :email")
    Basket findByEmail(@Param("email") String email);

}
