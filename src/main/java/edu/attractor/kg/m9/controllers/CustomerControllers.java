package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.exeptions.CustomerNotValidException;
import edu.attractor.kg.m9.exeptions.ResourceNotFoundException;
import edu.attractor.kg.m9.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerControllers {
    private final CustomerService customerService;

    @PostMapping("/newCustomer")
    public String addNewCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new CustomerNotValidException("Customer not valid");
        }
        try {
        customerService.addNewCustomer(customer);
        }catch (SQLException e){
            throw new CustomerNotValidException("Customer not valid");
        }
       return "redirect:/profile";
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id){
        try {
          return  customerService.getCustoerById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }


}
