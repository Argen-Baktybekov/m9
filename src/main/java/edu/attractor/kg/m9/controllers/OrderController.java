package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Basket;
import edu.attractor.kg.m9.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public String newOrder(HttpServletRequest request, Model model,
                           Authentication authentication, @RequestParam Long itemId) {
        var session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        for (var item : basket.getItemsWA()) {
            if (item.getItem().getId().equals(itemId)) {
                orderService.createOrder(authentication.getName(), item);
                basket.getItemsWA().remove(item);
                session.setAttribute("basket", basket);
                return "redirect:/customer/profile";
            }
        }
        return "redirect:/customer/profile";
    }

}
