package com.spring.aprendiendo.implementationService;

import com.spring.aprendiendo.entity.ProductEntity;
import com.spring.aprendiendo.repository.IProductEntity;
import com.spring.aprendiendo.service.IServiceProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImplementationProduct implements IServiceProductEntity {

    @Autowired
    private IProductEntity iProductEntity;

    @Override
    public List<ProductEntity> getAllProduct() {
        return iProductEntity.findAll();
    }
}
