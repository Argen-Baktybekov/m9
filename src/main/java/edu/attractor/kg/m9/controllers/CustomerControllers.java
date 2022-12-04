package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.*;
import edu.attractor.kg.m9.exeptions.CustomerNotValidException;
import edu.attractor.kg.m9.exeptions.ResourceNotFoundException;
import edu.attractor.kg.m9.service.BasketService;
import edu.attractor.kg.m9.service.CustomerService;
import edu.attractor.kg.m9.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerControllers {
    private final CustomerService customerService;
    private final BasketService basketService;
    private final OrderService orderService;

    @GetMapping("/newCustomer")
    public String newCustomer(Model model) {
        return "register";
    }

    @PostMapping("/newCustomer")
    public String addNewCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomerNotValidException("Customer not valid");
        }
        try {
            customerService.addNewCustomer(customer);
            return "redirect:/";
        } catch (Exception e) {
//            throw new CustomerNotValidException("Customer not valid");
            return "redirect:/customer/newCustomer";
        }
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        try {
            return customerService.getCustoerById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/profile")
    public String getProfile(HttpServletRequest request, Authentication authentication,
                             Model model) {
        try {
            var session = request.getSession();
            Basket basket = (Basket) session.getAttribute("basket");
            List<ItemWA> itemsWA;
            if (basket == null) {
                itemsWA = basketService.getMyBasket(authentication.getName()).getItemsWA();
            } else {
                itemsWA = basket.getItemsWA();
            }
            model.addAttribute("items", itemsWA);
            Customer customer = customerService.getCustomerByEmail(authentication.getName());
            model.addAttribute("user", customer);
            List<Order> orders = orderService.getOrdersByEmail(authentication.getName());
            model.addAttribute("orders", orders);
            return "/profile";
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/save")
    public String logout(HttpServletRequest request,
                         Authentication authentication) {
        var session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        if (basket != null) {
            basketService.saveMyBasket(basket, authentication.getName());
        }
        return "redirect:/logout";
    }

}
