package com.spring.jpa.persistency.repository;

import com.spring.jpa.persistency.entity.Customer;
import com.spring.jpa.persistency.entity.Local;
import com.spring.jpa.persistency.entity.Manager;
import com.spring.jpa.persistency.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ILocalRepositoryTest {

    @Autowired
    private ILocalRepository iLocalRepository;

    @Test
    void saveLocal() {

        Manager manager = Manager.builder()
                .firstName("carlos")
                .lastName("garcia")
                .build();

        Local local = Local.builder()
                .nameLocal("calzado")
                .floorLocal("second floor")
                .manager(manager)
                .build();

        iLocalRepository.save(local);
    }

    @Test
    void findAllLocals() {
        List<Local> localList = iLocalRepository.findAll();
        localList.forEach(System.out::println);
    }

    @Test
    void saveLocalWithOrder() {

        Manager manager = Manager.builder()
                .firstName("fernando")
                .lastName("gomez")
                .build();

        Order order = Order.builder()
                .description("gaseosas tamaña extra grande")
                .price(55.8)
                .build();

        Order order2 = Order.builder()
                .description("extra queso con peperoni")
                .price(77.8)
                .build();

        Local local = Local.builder()
                .nameLocal("pizas")
                .floorLocal("first floor")
                .manager(manager)
                //.orderList(List.of(order, order2))
                .build();

        iLocalRepository.save(local);
    }

    @Test
    void findAllLocalsWithOrders() {
        List<Local> localList = iLocalRepository.findAll();
        localList.forEach(System.out::println);
    }

    @Test
    void saveLocalWithCustomer() {
        Manager manager = Manager.builder()
                .firstName("david")
                .lastName("fandiño")
                .build();

        Customer customer = Customer.builder()
                .firstName("condorito")
                .lastName("chil")
                .email("condorito@gmail.com")
                .build();

        Customer customer2 = Customer.builder()
                .firstName("condorito pequeño")
                .lastName("pequeñin")
                .email("condoritoPeque@gmail.com")
                .build();

        Local local = Local.builder()
                .nameLocal("italiano restaurante")
                .floorLocal("first floor")
                .manager(manager)
                .customers(List.of(customer, customer2))
                .build();
        iLocalRepository.save(local);
    }

    @Test
    void findAllLocalsWithCustomers() {
        List<Local> localList = iLocalRepository.findAll();
        localList.forEach(System.out::println);
    }
}