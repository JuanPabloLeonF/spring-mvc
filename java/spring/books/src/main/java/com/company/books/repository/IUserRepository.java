package com.company.books.repository;

import com.company.books.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByNameUser(String nameUser);

    @Query("select u from User u where u.nameUser = ?1")
    User findByNameUserTwo(String nameUser);
}
