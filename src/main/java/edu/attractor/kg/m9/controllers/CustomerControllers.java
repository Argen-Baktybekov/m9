package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Basket;
import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.entities.Item;
import edu.attractor.kg.m9.entities.ItemWA;
import edu.attractor.kg.m9.exeptions.CustomerNotValidException;
import edu.attractor.kg.m9.exeptions.ResourceNotFoundException;
import edu.attractor.kg.m9.service.BasketService;
import edu.attractor.kg.m9.service.CustomerService;
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

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerControllers {
    private final CustomerService customerService;
    private final BasketService basketService;

    @GetMapping("/newCustomer")
    public String newCustomer (Model model){
        return "register";
    }
    @PostMapping("/newCustomer")
    public String addNewCustomer(@Valid Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new CustomerNotValidException("Customer not valid");
        }
        try {
        customerService.addNewCustomer(customer);
            return "redirect:/";
        }catch (Exception e){

//            throw new CustomerNotValidException("Customer not valid");
            return "redirect:/customer/newCustomer";
        }
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id){
        try {
          return  customerService.getCustoerById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/profile")
    public String getProfile(HttpServletRequest request, Authentication authentication,
                             Model model){
        try {
            var session = request.getSession();
            List<ItemWA> basketDB = basketService.getMyBasket(authentication.getName()).getItemsWA();
            model.addAttribute("items", basketDB);
            Customer customer= customerService.getCustomerByEmail(authentication.getName());
            model.addAttribute("user", customer);
            return "/profile";
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request,
                         Authentication authentication){

        var session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        if (basket != null) {
            basketService.saveMyBasket(basket, authentication.getName());
        }
        session.invalidate();

        return "redirect:/";

    }


}
