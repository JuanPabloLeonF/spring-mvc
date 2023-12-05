package com.mvc.spring.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person_entity")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long idPerson;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "identification", length = 10)
    private String identification;

    public PersonEntity() {
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
