package com.mvc.spring.domain.service;

import com.mvc.spring.domain.models.PersonModel;
import com.mvc.spring.persistence.errors.exception.NotFoundPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonService {

    PersonModel getPersonById(Long personId) throws NotFoundPerson;
    List<PersonModel> getAllPerson();
    PersonModel savePerson(PersonModel personModel);
    PersonModel updatePerson(PersonModel personModel, Long personId);
    String deletePerson(Long personId);
    PersonModel findByName(String name);
}
