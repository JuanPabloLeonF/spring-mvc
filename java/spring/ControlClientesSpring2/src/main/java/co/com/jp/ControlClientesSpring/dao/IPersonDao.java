package co.com.jp.ControlClientesSpring.dao;

import co.com.jp.ControlClientesSpring.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonDao extends JpaRepository<Person, Long>{ 
}
