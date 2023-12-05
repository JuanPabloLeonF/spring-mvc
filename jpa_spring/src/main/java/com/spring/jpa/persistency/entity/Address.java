package com.spring.jpa.persistency.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "city",
                column = @Column(name = "customer_city")
        ),
        @AttributeOverride(
                name = "mainStreet",
                column = @Column(name = "secondary_street")
        ),
        @AttributeOverride(
                name = "secondaryStreet",
                column = @Column(name = "customer_secondary_street")
        )
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "main_street", length = 30)
    private String mainStreet;

    @Column(name = "secondary_street", length = 30)
    private String secondaryStreet;
}
