package co.com.jp.ControlClientesSpring.services;

import co.com.jp.ControlClientesSpring.dao.IPersonDao;
import co.com.jp.ControlClientesSpring.domain.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImplementation implements IPersonService {

    @Autowired
    private IPersonDao iPersonDao;

    @Override
    @Transactional(readOnly = true)
    public List<Person> getListPerson() {
        return (List<Person>) iPersonDao.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void savePerson(Person person) {
        iPersonDao.save(person);
    }

    @Override
    @Transactional(readOnly = false)
    public void deletePerson(Person person) {
        iPersonDao.deleteById(person.getIdPerson());
    }

    @Override
    @Transactional(readOnly = true)
    public Person findByIdPerson(Person person) {
        return iPersonDao.findById(person.getIdPerson()).orElse(null);
    }
}
