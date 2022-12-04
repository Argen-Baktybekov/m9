package edu.attractor.kg.m9.repositories;

import edu.attractor.kg.m9.entities.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(nativeQuery = true, value = "insert into authorities(username) values (:email)")
    void saveAuthorities(String email);

    @Query
    List<Customer> findCustomersByFirstNameAndLastNameContains(String firstName, String lastName);

    @Query
    List<Customer> findCustomersByPhoneContains(String phone);

    Customer findCustomersByEmail(String email);

    @Modifying
    @Transactional
    @Query("update Customer SET firstName = :firstName where id = :id")
    void changeName(String firstName, Long id);

    @Modifying
    @Transactional
    @Query("update Customer SET lastName = :lastName where id = :id")
    void changeLastName(String lastName, Long id);

    @Transactional
    @Modifying
    @Query("update Customer SET phone = :phone where id = :id")
    void changePhone(String phone, Long id);


}
