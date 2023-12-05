package com.spring.aprendiendo.controller;

import com.spring.aprendiendo.entity.ProductEntity;
import com.spring.aprendiendo.service.IServiceProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ControllerProduct {

    @Autowired
    private IServiceProductEntity iServiceProductEntity;

    @GetMapping("/todosproductos")
    public List<ProductEntity> allProduct() {
        return iServiceProductEntity.getAllProduct();
    }
}
