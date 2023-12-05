
import org.example.dao.PersonDao;
import org.example.domain.Person;

public class HelloWordHibernate {
    
    public static void main(String[] args) {
        
        PersonDao personDao = new PersonDao();
        
        Person person = new Person();
        person.setIdPerson(4);
        
        person = personDao.findPersonById(person);
        
       //personDao.createPerson(person);
       //personDao.updatePerson(person);
       personDao.deletePerson(person);
       personDao.showPerson();
    }
}
