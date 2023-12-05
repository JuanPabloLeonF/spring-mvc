package com.mvc.spring.domain.models;


public class PersonModel {
    private Long personId;
    private String namePerson;
    private String identificationPerson;

    public PersonModel() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getIdentificationPerson() {
        return identificationPerson;
    }

    public void setIdentificationPerson(String identificationPerson) {
        this.identificationPerson = identificationPerson;
    }
}
