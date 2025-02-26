package fr.epsi.b3devc1.sylvainmjc.bestioles.repositories;

import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
