package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Basket;
import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query("select b from Basket b where b.customer.email = :email")
    Basket findByEmail(@Param("email") String email);

//    @Modifying
//    @Transactional
//    @Query("update Basket b set Basket = :basket where b.id = 1L")
//    void updateBasket(Basket basket, Long bId );

}
