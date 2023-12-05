package com.spring.aprendiendo.service;

import com.spring.aprendiendo.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceProductEntity {

    List<ProductEntity> getAllProduct();
}
