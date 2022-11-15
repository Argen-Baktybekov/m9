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

//    @Query(value = "select Order from Order o where year(o.time)= :year and month(o.time) = :month and day(o.time) = :day")
//    List<Order> findAllByMyDate(int year, int month, int day);
//
    @Query(nativeQuery = true, value = "select * from orders o inner join orders_items oi on o.id = oi.order_id inner join item i on i.id = oi.items_id where i.name = :name")
    List<Order>findOrderByItemName(String name);

    @Query(nativeQuery = true, value = "select * from orders o inner join orders_items oi on o.id = oi.order_id inner join item i on i.id = oi.items_id where i.category = :category")
    List<Order>findOrderByItemCategory(String category);
//
    Order findOrderByCustomerPhone(String phone);
    Order findOrderByCustomer_FirstName(String firstName);

 }
