package com.mvc.spring.persistence.mapper;

import com.mvc.spring.domain.models.PersonModel;
import com.mvc.spring.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IPersonMapper {

    @Mappings(value = {
            @Mapping(source = "personEntity.idPerson", target = "personId"),
            @Mapping(source = "personEntity.name", target = "namePerson"),
            @Mapping(source = "personEntity.identification", target = "identificationPerson")
    })
    PersonModel personEntityToPersonModel(PersonEntity personEntity);

    @Mappings(value = {
            @Mapping(target = "idPerson",  source= "personModel.personId"),
            @Mapping(target = "name", source = "personModel.namePerson"),
            @Mapping(target = "identification", source = "personModel.identificationPerson")
    })
    PersonEntity personModelToPersonEntity(PersonModel personModel);
}
