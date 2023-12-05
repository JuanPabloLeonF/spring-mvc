package co.com.jp.ControlClientesSpring.dao;

import co.com.jp.ControlClientesSpring.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDao extends CrudRepository<Person, Long>{ 
}
