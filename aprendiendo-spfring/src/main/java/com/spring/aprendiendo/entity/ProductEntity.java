package com.spring.aprendiendo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idProduct;

    @Column(name = "name_product")
    private String nameProduct;

    private String description;
}
