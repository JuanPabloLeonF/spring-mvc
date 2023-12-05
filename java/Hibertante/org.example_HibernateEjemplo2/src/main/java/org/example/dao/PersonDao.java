package org.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.example.domain.Person;

public class PersonDao {
    
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PersonDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("HibernatePU");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public void showPerson(){
        String hql = "SELECT p FROM Person p";
        Query query = entityManager.createQuery(hql);
        List<Person> listPerson = query.getResultList();
        
        for (Person person : listPerson) {
            System.out.println("person = " + person);
        }
    }
    
    public void createPerson(Person person) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public void updatePerson(Person person) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(person);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) {
                //entityManager.close();
            }
        }

    }
    
    public void deletePerson(Person person) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(person));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager != null) {
                //entityManager.close();
            }
        }
    }
    
    public Person findPersonById(Person person) {
        return entityManager.find(Person.class, person.getIdPerson());
    }
}
