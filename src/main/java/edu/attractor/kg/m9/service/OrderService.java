package edu.attractor.kg.m9.service;

import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.entities.Item;
import edu.attractor.kg.m9.entities.Order;
import edu.attractor.kg.m9.repositories.CustomerRepository;
import edu.attractor.kg.m9.repositories.ItemRepository;
import edu.attractor.kg.m9.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

public void addOrder(){
    Customer customer = customerRepository.findById(1L).get();
    List<Item> items = itemRepository.findAllByCategoryOrderById("flowers");
    Order order = new Order(1l, customer, items, LocalDateTime.now(), 0);
    orderRepository.save(order);
}

@Bean
public void printOrder(){
    addOrder();
    System.out.println(orderRepository.findAll());

    LocalDateTime time = LocalDateTime.now();
    System.out.println(orderRepository.findAllByDate(time.getYear(), time.getMonthValue(), time.getDayOfMonth()));

}
}
