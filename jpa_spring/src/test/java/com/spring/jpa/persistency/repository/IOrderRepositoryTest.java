package com.spring.jpa.persistency.repository;

import com.spring.jpa.persistency.entity.Local;
import com.spring.jpa.persistency.entity.Manager;
import com.spring.jpa.persistency.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class IOrderRepositoryTest {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Test
    void saveOrder() {
        Manager manager = Manager.builder()
                .firstName("idaly")
                .lastName("fonseca")
                .build();

        Local local = Local.builder()
                .nameLocal("mundi pollo")
                .floorLocal("first floor")
                .manager(manager)
                .build();

        Order order = Order.builder()
                .description("pollo 2 por 1")
                .price(89.70)
                .local(local).build();

        iOrderRepository.save(order);
    }

    @Test
    void findAllOrder() {

        List<Order> orderList = iOrderRepository.findAll();
        orderList.forEach(System.out::println);
    }

    @Test
    void findOrderPaging() {
        PageRequest firstPageWithThreeRecords = PageRequest.of(0, 3);
        List<Order> orderList = iOrderRepository.findAll(firstPageWithThreeRecords).getContent();
        Long totalElement = iOrderRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        Integer totalPages = iOrderRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElement = " + totalElement);
        orderList.forEach(System.out::println);
    }

    @Test
    void findAllOrdersWithSorting() {
        PageRequest sortPriceAsc = PageRequest.of(0, 3, Sort.by("price").ascending());
        PageRequest sortPriceDesc = PageRequest.of(0, 3, Sort.by("price").descending());
        List<Order> orderListAsc = iOrderRepository.findAll(sortPriceAsc).getContent();
        List<Order> orderListDesc = iOrderRepository.findAll(sortPriceDesc).getContent();
        orderListAsc.forEach(System.out::println);
        orderListDesc.forEach(System.out::println);
    }

    @Test
    void findByDescriptionContains() {
        PageRequest page = PageRequest.of(0, 5);
        List<Order> orderList = iOrderRepository.findByDescriptionContains("po", page).getContent();
        orderList.forEach(System.out::println);
    }
}