package com.mvc.spring.domain.repository;

import com.mvc.spring.domain.models.PersonModel;
import com.mvc.spring.persistence.errors.exception.NotFoundPerson;

import java.util.List;

public interface IPersonRepository {

    PersonModel getPersonById(Long idPerson) throws NotFoundPerson;
    List<PersonModel> getAllPerson();
    PersonModel savePerson(PersonModel personModel);
    PersonModel updatePerson(PersonModel personModel, Long personId);

    String deletePersonById(Long personId);

    PersonModel findByName(String name);
}
