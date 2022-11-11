package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
