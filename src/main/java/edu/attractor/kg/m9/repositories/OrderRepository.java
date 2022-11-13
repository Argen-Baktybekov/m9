package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select Order from Order where year(time)= :year and month(time) = :month and day(time) = :day")
    List<Order> findAllByDate(int year, int month, int day);


 }
