package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerControllers {
    private final CustomerService customerService;

    @PostMapping("/newCustomer")
    public ResponseEntity<?> addNewCustomer(@RequestBody Customer customer){
       return new ResponseEntity<>(customerService.addNewCustomer(customer), HttpStatus.OK );
    }

}
