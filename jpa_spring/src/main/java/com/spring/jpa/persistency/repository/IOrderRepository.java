package com.spring.jpa.persistency.repository;

import com.spring.jpa.persistency.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByDescriptionContains(String description, Pageable pageable);
}