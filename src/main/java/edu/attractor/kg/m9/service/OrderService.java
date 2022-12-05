package edu.attractor.kg.m9.service;

import edu.attractor.kg.m9.entities.ItemWA;
import edu.attractor.kg.m9.entities.Order;
import edu.attractor.kg.m9.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void createOrder(String email, ItemWA item) {
        Order order = new Order(email, item);
        orderRepository.save(order);
    }

    public List<Order> getOrdersByEmail(String email) {
        return orderRepository.findOrdersByEmail(email);
    }
}