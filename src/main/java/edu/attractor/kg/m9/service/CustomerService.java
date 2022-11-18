package edu.attractor.kg.m9.service;

import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Long addNewCustomer(Customer customer) {
        Customer save = customerRepository.save(customer);
        return save.getId();
    }

//    @Bean
    public void printCustomer(){
        System.out.println(customerRepository.findAll());

        customerRepository.changeLastName("Baktybekov", 1L);
        customerRepository.changeName("qwerty", 1L);
        System.out.println(customerRepository.findCustomersByFirstNameAndLastNameContains("qwerty", "argen"));
        customerRepository.changePhone("996703039401", 1L);
        System.out.println(customerRepository.findCustomersByPhoneContains("039401"));

        System.out.println(customerRepository.findAll());

    }
}
