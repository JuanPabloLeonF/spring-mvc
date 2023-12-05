package com.spring.jpa.persistency.repository;

import com.spring.jpa.persistency.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, Long> {

}