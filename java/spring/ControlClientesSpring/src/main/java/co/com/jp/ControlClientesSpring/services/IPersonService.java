package co.com.jp.ControlClientesSpring.services;

import co.com.jp.ControlClientesSpring.domain.Person;
import java.util.List;

public interface IPersonService {
    
    public List<Person> getListPerson();
    public void savePerson(Person person);
    public void deletePerson(Person person);
    public Person findByIdPerson(Person person);
}
