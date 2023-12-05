package com.spring.jpa.persistency.repository;

import com.spring.jpa.persistency.entity.Address;
import com.spring.jpa.persistency.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ICustomerRepositoryTest {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Test
    void saveCustomer() {
        Customer customer = Customer.builder()
                .idCustomer(4L)
                .firstName("camila")
                .lastName("guzman")
                .email("papo@gmail.com")
                    .build();

        iCustomerRepository.save(customer);
    }

    @Test
    void findByFirstName() {
        Customer customer = iCustomerRepository.findByFirstName("julian").get();
        System.out.println(customer);
    }

    @Test
    void findAllPerson() {
        List<Customer> customerList = iCustomerRepository.findAll();
        customerList.forEach(System.out::println);
    }

    @Test
    void saveCustomerWithAddress() {
        Address address = Address.builder()
                .city("bucaramanga")
                .mainStreet("calle 15B")
                .secondaryStreet("calle 19A")
                .build();

        Customer customer = Customer.builder()
                .firstName("mirian")
                .lastName("leon")
                .email("miri123lon@gmail")
                .address(address)
                .build();

        iCustomerRepository.save(customer);
    }

    @Test
    void deleteCustomerById() {
        iCustomerRepository.deleteById(2L);
    }

    @Test
    void findByFirstNameContaining() {
        List<Customer> customerList = iCustomerRepository.findByFirstNameContaining("j");
        customerList.forEach(System.out::println);
    }

    @Test
    void findByLastNameNotNull() {
        List<Customer> customerList = iCustomerRepository.findByLastNameNotNull();
        customerList.forEach(System.out::println);
    }

    @Test
    void findByAddress_CityIgnoreCase() {
        List<Customer> customerList = iCustomerRepository.findByAddress_CityIgnoreCase("cucuta");
        customerList.forEach(System.out::println);
    }

    @Test
    void findByLastNameOrderByFirstNameAsc() {
        List<Customer> customerList = iCustomerRepository.findByLastNameOrderByFirstNameAsc("leon");
        customerList.forEach(System.out::println);
    }

    @Test
    void getCustomerByEmail() {
        Customer customer = iCustomerRepository.getCustomerByEmail("papo123lon@gmail");
        System.out.println("customer = " + customer);
    }
    
    @Test
    void getFirstNameCustomerByEmail() {
        String firstName = iCustomerRepository.getFirstNameCustomerByEmail("papo123lon@gmail");
        System.out.println("firstName = " + firstName);
    }

    @Test
    void getCustomerByEmailNative() {
        Customer customer = iCustomerRepository.getCustomerByEmailNative("papo123lon@gmail");
        System.out.println("customer = " + customer);
    }

    @Test
    void getCustomerByEmailWithParam() {
        Customer customer = iCustomerRepository.getCustomerByEmailWithParam("papo123lon@gmail");
        System.out.println("customer = " + customer);
    }

    @Test
    void updateCustomerByEmail() {
        iCustomerRepository.updateCustomerByEmail("javier" ,"papo123lon@gmail");
        Customer customer = iCustomerRepository.findByFirstName("javier").get();
        System.out.println("customer = " + customer);
    }

    @Test
    void deleteByLastName() {
        iCustomerRepository.deleteByFirstName("javier");
        List<Customer> customerList = iCustomerRepository.findAll();
        customerList.forEach(System.out::println);
    }

    @Test
    void deleteCustomerByFirstName() {
        iCustomerRepository.deleteCustomerByFirstName("Juan");
        List<Customer> customerList = iCustomerRepository.findAll();
        customerList.forEach(System.out::println);
    }
}