package com.spring.jpa.persistency.repository;

import com.spring.jpa.persistency.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IManagerRepositoryTest {

    @Autowired
    private IManagerRepository iManagerRepository;

    @Test
    void findAllManagers() {
        List<Manager> managerList = iManagerRepository.findAll();
        managerList.forEach(System.out::println);
    }
}