package fr.epsi.b3devc1.sylvainmjc.bestioles.repositories;

import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Animal;
import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    // TP4
    List<Person> findByLastnameOrFirstname(String lastname, String firstname);
    List<Person> findByAgeGreaterThanEqual(int age);

    // TP5
    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageMin AND :ageMax")
    List<Person> findByAgeBetween(@Param("ageMin") int ageMin, @Param("ageMax") int ageMax);

    @Query("SELECT p FROM Person p JOIN p.animals a WHERE a = :animal")
    List<Person> findByAnimal(@Param("animal") Animal animal);

}