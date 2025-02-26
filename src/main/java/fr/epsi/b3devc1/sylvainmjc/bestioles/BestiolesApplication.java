package fr.epsi.b3devc1.sylvainmjc.bestioles;

import fr.epsi.b3devc1.sylvainmjc.bestioles.repositories.AnimalRepository;
import fr.epsi.b3devc1.sylvainmjc.bestioles.repositories.PersonRepository;
import fr.epsi.b3devc1.sylvainmjc.bestioles.repositories.RoleRepository;
import fr.epsi.b3devc1.sylvainmjc.bestioles.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

    private AnimalRepository animalRepository;

    private PersonRepository personRepository;

    private RoleRepository roleRepository;

    private SpeciesRepository speciesRepository;

    @Autowired
    public BestiolesApplication(AnimalRepository animalRepository, PersonRepository personRepository, RoleRepository roleRepository, SpeciesRepository speciesRepository) {
        this.animalRepository = animalRepository;
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.speciesRepository = speciesRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(" --- Animals --- ");
        this.animalRepository.findAll().forEach(System.out::println);

        System.out.println(" --- Persons --- ");
        this.personRepository.findAll().forEach(System.out::println);

        System.out.println(" --- Roles --- ");
        this.roleRepository.findAll().forEach(System.out::println);

        System.out.println(" --- Scpecies --- ");
        this.speciesRepository.findAll().forEach(System.out::println);
    }
}
