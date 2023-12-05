package com.mvc.spring.persistence.implementation;

import com.mvc.spring.domain.models.PersonModel;
import com.mvc.spring.domain.repository.IPersonRepository;
import com.mvc.spring.persistence.crud.IPersonCrud;
import com.mvc.spring.persistence.entity.PersonEntity;
import com.mvc.spring.persistence.errors.exception.NotFoundPerson;
import com.mvc.spring.persistence.mapper.IPersonMapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonImplementation implements IPersonRepository {

    private final IPersonCrud iPersonCrud;

    private final IPersonMapper iPersonMapper;

    public PersonImplementation(IPersonCrud iPersonCrud, IPersonMapper iPersonMapper) {
        this.iPersonCrud = iPersonCrud;
        this.iPersonMapper = iPersonMapper;
    }

    @Override
    public PersonModel getPersonById(Long idPerson) throws NotFoundPerson {
        return iPersonCrud.findById(idPerson)
                .map(iPersonMapper::personEntityToPersonModel)
                .orElseThrow(() -> new NotFoundPerson("Persona no encontrada"));
    }

    @Override
    public List<PersonModel> getAllPerson() {
        return Optional.of(iPersonCrud.findAll())
                .filter(list -> !list.isEmpty())
                .map(list -> list.stream()
                        .map(iPersonMapper::personEntityToPersonModel)
                        .toList())
                .orElse(null);
    }

    @Override
    public PersonModel savePerson(PersonModel personModel) {
        PersonEntity personEntity = iPersonCrud.save(iPersonMapper.personModelToPersonEntity(personModel));
        return iPersonCrud.findById(personEntity.getIdPerson())
                .map(iPersonMapper::personEntityToPersonModel)
                .orElse(null);
    }

    @Override
    public PersonModel updatePerson(PersonModel personModel, Long personId) {
        return iPersonCrud.findById(personId)
                .map(existingPerson -> {
                    PersonEntity updatedPersonEntity = iPersonMapper.personModelToPersonEntity(personModel);
                    updatedPersonEntity.setIdPerson(personId);
                    iPersonCrud.save(updatedPersonEntity);
                    return iPersonMapper.personEntityToPersonModel(updatedPersonEntity);

                })
                .orElse(null);
    }

    @Override
    public String deletePersonById(Long personId) {
        return iPersonCrud.findById(personId)
                .map(personEntity -> {
                    iPersonCrud.deleteById(personEntity.getIdPerson());
                    return "Correctly deleted ";
                })
                .orElse( null);
    }


    @Override
    public PersonModel findByName(String name) {
        return Optional.ofNullable(iPersonCrud.findByNameIgnoreCase(name))
                .map(iPersonMapper::personEntityToPersonModel)
                .orElse(null);
    }
}
