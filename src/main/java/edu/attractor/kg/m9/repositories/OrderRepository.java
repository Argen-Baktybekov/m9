package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(nativeQuery = true, value = "select * from orders  where extract(year from time)= :year and extract(month from time)= :month and extract(day from time)= :day")
    List<Order> findAllByMyDate(int year, int month, int day);

    @Query(nativeQuery = true, value = "select * from orders o inner join orders_items oi on o.id = oi.order_id inner join item i on i.id = oi.items_id where i.name = :name")
    List<Order> findOrderByItemName(String name);

    @Query(nativeQuery = true, value = "select * from orders o inner join orders_items oi on o.id = oi.order_id inner join item i on i.id = oi.items_id where i.category = :category")
    List<Order> findOrderByItemCategory(String category);

    //
    Order findOrderByCustomerPhone(String phone);

    Order findOrderByCustomer_FirstName(String firstName);

}
