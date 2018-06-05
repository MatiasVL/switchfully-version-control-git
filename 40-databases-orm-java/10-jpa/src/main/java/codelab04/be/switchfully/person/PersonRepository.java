package codelab04.be.switchfully.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Person save(Person person){
        entityManager.persist(person);
        return person;
    }

    public Person findByName(String lastName){
        return entityManager.createQuery("from Person where lastName = :lastName", Person.class)
                    .setParameter("lastName", lastName)
                    .getSingleResult();
    }
}
