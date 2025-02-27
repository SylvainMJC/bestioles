package fr.epsi.b3devc1.sylvainmjc.bestioles.repositories;

import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Person;

import java.util.List;

public interface PersonRepositoryCustom {

    void deletePersonsWithoutAnimals();

    List<Person> generateRandomPersons(int count);
}
