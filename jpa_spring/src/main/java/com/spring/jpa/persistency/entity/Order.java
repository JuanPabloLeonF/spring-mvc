package com.spring.jpa.persistency.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Long idOrder;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    //@ToString.Exclude
    @ManyToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(name = "local_id")
    private Local local;

}
