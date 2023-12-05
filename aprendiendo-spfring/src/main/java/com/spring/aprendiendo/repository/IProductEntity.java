package com.spring.aprendiendo.repository;

import com.spring.aprendiendo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductEntity extends JpaRepository<ProductEntity, Long> {
}
