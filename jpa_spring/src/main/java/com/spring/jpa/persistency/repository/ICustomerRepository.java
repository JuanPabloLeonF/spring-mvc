package com.spring.jpa.persistency.repository;

import com.spring.jpa.persistency.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstNameContaining(String firstName);

    List<Customer> findByLastNameNotNull();

    @Transactional
    @Modifying
    @Query("update Customer c set c.firstName = :firstName where c.email = :email")
    void updateCustomerByEmail(@Param("firstName") String firstName, @Param("email") String email);

    @Transactional
    @Modifying
    void deleteByFirstName(String lastName);

    @Transactional
    @Modifying
    @Query("delete from Customer c where c.firstName = :firstName")
    void deleteCustomerByFirstName(String firstName);

    List<Customer> findByAddress_CityIgnoreCase(String city);

    List<Customer> findByLastNameOrderByFirstNameAsc(String lastName);

    @Query("select c from Customer c where c.email = ?1")
    Customer getCustomerByEmail(String email);

    @Query("select c.firstName from Customer c where c.email = ?1")
    String getFirstNameCustomerByEmail(String email);

    @Query(
            value = "SELECT * FROM customer WHERE email = ?1",
            nativeQuery = true
    )
    Customer getCustomerByEmailNative(String email);

    @Query("select c from Customer c where c.email = :email")
    Customer getCustomerByEmailWithParam(@Param("email") String email);

}
