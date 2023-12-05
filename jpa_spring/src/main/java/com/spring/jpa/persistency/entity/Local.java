package com.spring.jpa.persistency.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "local")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local", nullable = false)
    private Long idLocal;

    @Column(name = "name_local", length = 40)
    private String nameLocal;

    @Column(name = "floor_local", length = 40)
    private String floorLocal;

    @ToString.Exclude
    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "manager_id")
    private Manager manager;

    //@Builder.Default
    //@OneToMany(
    //        cascade = CascadeType.PERSIST,
    //        fetch = FetchType.EAGER
    //)
    //@JoinColumn(name = "local_id")
    //private List<Order> orderList = new ArrayList<>();


    //@ToString.Exclude
    @Builder.Default
    @ManyToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    @JoinTable(name = "local_customers",
            joinColumns = @JoinColumn(name = "local_id_local"),
            inverseJoinColumns = @JoinColumn(name = "customers_id_customer")
    )
    private List<Customer> customers = new ArrayList<>();

}
