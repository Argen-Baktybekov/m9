package edu.attractor.kg.m9.service;

import edu.attractor.kg.m9.entities.Basket;
import edu.attractor.kg.m9.repositories.BasketRepository;
import edu.attractor.kg.m9.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final CustomerRepository customerRepository;

    public Basket getMyBasket(String email){
        return basketRepository.findByEmail(email);
    }

    public void saveMyBasket(Basket basket, String email) {
        basketRepository.saveAndFlush(basket);

//        basketRepository.updateBasket(basket, basket.getId() );
    }
}
