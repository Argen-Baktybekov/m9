package edu.attractor.kg.m9.service;

import edu.attractor.kg.m9.entities.Authority;
import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.exeptions.ResourceNotFoundException;
import edu.attractor.kg.m9.repositories.AuthorityRepository;
import edu.attractor.kg.m9.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder encoder;

    public Customer getCustoerById(long id){
        Optional<Customer> c =  customerRepository.findById(id);
        if (c.isEmpty()){
            throw new ResourceNotFoundException("Customer not found");
        }
        return c.get();
    }
    public Long addNewCustomer(Customer customer)  throws SQLException{
        customer.setPassword(encoder.encode(customer.getPassword()));
        Customer saved = customerRepository.save(customer);
        Authority authority = new Authority();
        authority.setUsername(customer.getEmail());
        authority.setAuthority("USER");
        authorityRepository.save(authority);
        return saved.getId();
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
