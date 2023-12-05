
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.example.domain.Person;

public class HelloWordHibernate {
    
    public static void main(String[] args) {
        String hql = "SELECT p FROM Person p";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Query query = entityManager.createQuery(hql);
        List<Person> personList = query.getResultList();
        
        for (Person person : personList) {
            System.out.println("person = " + person);
        }
    }
}
