package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query
    Page<Item> findAllBy(Pageable pageable);

    @Query
    List<Item> findAllByCategoryOrderById(String category);

    @Query
    Page<Item> findItemByNameIgnoreCaseOrDescriptionContains(String name, String description, Pageable pageable);



    @Modifying
    @Transactional
    @Query("update Item  set description = :newDescription where id = :id ")
    void changeDescription(String newDescription, Long id);
    @Modifying
    @Transactional
    @Query("update Item set price = :price where id = :id ")
    void changePrice(Double price, Long id);

    @Query("select name from Item where price <= :maxPrice")
    List<String> getItemsByMaxPrice(double maxPrice);

}
