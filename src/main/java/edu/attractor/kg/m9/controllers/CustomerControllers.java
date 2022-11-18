package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerControllers {
    private final CustomerService customerService;

    @PostMapping("/newCustomer")
    public String addNewCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "newCustomer";

        customerService.addNewCustomer(customer);
       return "redirect:/profile";
    }

}
