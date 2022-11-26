package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.exeptions.CustomerNotValidException;
import edu.attractor.kg.m9.exeptions.ResourceNotFoundException;
import edu.attractor.kg.m9.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerControllers {
    private final CustomerService customerService;

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
}
