package fr.epsi.b3devc1.sylvainmjc.bestioles.repositories;

import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void deletePersonsWithoutAnimals() {
        entityManager.createQuery("DELETE FROM Person p WHERE p.animals IS EMPTY").executeUpdate();
    }

    @Transactional
    public List<Person> generateRandomPersons(int count) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Person person = new Person();
            person.setFirstname("Firstname" + i);
            person.setLastname("Lastname" + i);
            person.setLogin("Login" + i);
            person.setPassword("Password" + i);
            person.setAge((int) (Math.random() * 100));
            person.setActive((byte) 1);
            entityManager.persist(person);
            persons.add(person);
        }
        return persons;
    }
}
