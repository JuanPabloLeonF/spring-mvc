package co.com.jp.HolaMundoSpringData.dao;

import co.com.jp.HolaMundoSpringData.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDao extends CrudRepository<Person, Long>{ 
}
