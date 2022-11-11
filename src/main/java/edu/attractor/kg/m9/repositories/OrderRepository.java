package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
