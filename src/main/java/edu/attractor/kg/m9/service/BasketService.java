package edu.attractor.kg.m9.service;

import edu.attractor.kg.m9.entities.Basket;
import edu.attractor.kg.m9.repositories.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    public Basket getMyBasket(String email) {
        return basketRepository.findByEmail(email);
    }
    public void saveMyBasket(Basket basket, String email) {
        try {
            var newBasket = basketRepository.saveAndFlush(basket);
        } catch (RuntimeException e) {
            System.out.println(email + ":delete some Item");
        }
    }
}
