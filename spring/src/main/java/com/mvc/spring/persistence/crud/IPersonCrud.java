package com.mvc.spring.persistence.crud;

import com.mvc.spring.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonCrud extends JpaRepository<PersonEntity, Long> {

    PersonEntity findByNameIgnoreCase(String name);
}
