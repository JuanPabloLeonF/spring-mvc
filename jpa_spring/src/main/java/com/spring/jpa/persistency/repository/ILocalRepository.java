package com.spring.jpa.persistency.repository;

import com.spring.jpa.persistency.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalRepository extends JpaRepository<Local, Long> {

}