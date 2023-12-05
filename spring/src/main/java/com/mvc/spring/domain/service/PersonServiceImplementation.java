package com.mvc.spring.domain.service;

import com.mvc.spring.domain.models.PersonModel;
import com.mvc.spring.domain.repository.IPersonRepository;
import com.mvc.spring.persistence.errors.exception.NotFoundPerson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImplementation implements IPersonService{

    private final IPersonRepository iPersonRepository;

    public PersonServiceImplementation(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }
    @Override
    public PersonModel getPersonById(Long personId) throws NotFoundPerson {
        return iPersonRepository.getPersonById(personId);
    }

    @Override
    public List<PersonModel> getAllPerson() {
        return iPersonRepository.getAllPerson();
    }

    @Override
    public PersonModel savePerson(PersonModel personModel) {
        return iPersonRepository.savePerson(personModel);
    }

    @Override
    public PersonModel updatePerson(PersonModel personModel, Long personId) {
        return iPersonRepository.updatePerson(personModel, personId);
    }

    @Override
    public String deletePerson(Long personId) {
        return Optional.of(iPersonRepository.deletePersonById(personId))
                .orElse(null);
    }

    @Override
    public PersonModel findByName(String name) {
        return iPersonRepository.findByName(name);
    }
}
