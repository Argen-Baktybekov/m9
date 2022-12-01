package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Basket;
import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.entities.Item;
import edu.attractor.kg.m9.service.BasketService;
import edu.attractor.kg.m9.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
    private final ItemService itemService;

    @GetMapping()
    public String getBasket(HttpServletRequest request, Authentication authentication, Model model) {
        var session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        if (basket != null) {
            model.addAttribute("basket", basket);
            return "basket";
        }
        Basket basketDB = basketService.getMyBasket(authentication.getName());
        session.setAttribute("basket", basketDB);
        model.addAttribute("basket", basket);
        return "basket";
    }

    @PostMapping("/item")
    public String addItemToBasket(HttpServletRequest request,
                                  Long itemId,
                                  Model model,
    Authentication authentication) {
        var session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        Item item = itemService.getItemById(itemId);
        if (basket == null) {
            basket = basketService.getMyBasket(authentication.getName());
        }
        if (item == null) {
//            basketService.saveMyBasket(basket,authentication.getName());
            return "redirect:/login";
        }
        basket.getItems().add(item);
        model.addAttribute("basket", basket);
        session.setAttribute("basket", basket);
        basketService.saveMyBasket(basket,authentication.getName());
        return "basket";
    }

    @PostMapping("/delete/item")
    public String deleteItemFromBasket(HttpServletRequest request,
                                        Authentication authentication,
                                       Long itemId,
                                       Model model) {
        var session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        for (var item : basket.getItems()) {
            if (item.getId() == itemId) {
                basket.getItems().remove(item);
                break;
            }
        }
        model.addAttribute("basket", basket);
        session.setAttribute("basket", basket);
        basketService.saveMyBasket(basket,authentication.getName());
        return "basket";
    }

    @PostMapping("/itemplus")
    public String plusItemToBasket(HttpServletRequest request,
                                  Long itemId,
                                  Model model,
                                  Authentication authentication) {
        var session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        for (var item : basket.getItems()) {
            if (item.getId() == itemId) {
               item.setNumber(item.getNumber()+1);
                break;
            }
        }
        model.addAttribute("basket", basket);
        session.setAttribute("basket", basket);
        basketService.saveMyBasket(basket,authentication.getName());
        return "basket";
    }
}
