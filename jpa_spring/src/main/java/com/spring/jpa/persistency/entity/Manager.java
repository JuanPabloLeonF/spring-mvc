package com.spring.jpa.persistency.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "manager")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manager", nullable = false)
    private Long idManager;

    @Column(name = "first_name", length = 40)
    private String firstName;

    @Column(name = "last_name", length = 40)
    private String lastName;

    @OneToOne(
            mappedBy = "manager",
            fetch = FetchType.EAGER
    )
    private Local local;

}
