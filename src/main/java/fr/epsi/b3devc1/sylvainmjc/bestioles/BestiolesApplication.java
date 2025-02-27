package fr.epsi.b3devc1.sylvainmjc.bestioles;

import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Animal;
import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Person;
import fr.epsi.b3devc1.sylvainmjc.bestioles.models.Species;
import fr.epsi.b3devc1.sylvainmjc.bestioles.repositories.AnimalRepository;
import fr.epsi.b3devc1.sylvainmjc.bestioles.repositories.PersonRepository;
import fr.epsi.b3devc1.sylvainmjc.bestioles.repositories.RoleRepository;
import fr.epsi.b3devc1.sylvainmjc.bestioles.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

//        System.out.println(" --- Animals --- ");
//        this.animalRepository.findAll().forEach(System.out::println);
//
//        System.out.println(" --- Persons --- ");
//        this.personRepository.findAll().forEach(System.out::println);
//
//        System.out.println(" --- Roles --- ");
//        this.roleRepository.findAll().forEach(System.out::println);
//
//        System.out.println(" --- Scpecies --- ");
//        this.speciesRepository.findAll().forEach(System.out::println);

        System.out.println(" --- SpeciesRepository tests --- ");
        System.out.println(" - findFirstByCommonName - ");
        System.out.println(this.speciesRepository.findFirstByCommonName("Chien"));

        System.out.println(" - findByLatinNameContainingIgnoreCase - ");
        this.speciesRepository.findByLatinNameContainingIgnoreCase("canis").forEach(System.out::println);

        System.out.println(" - findAllOrderByCommonNameAsc - ");
        this.speciesRepository.findAllOrderByCommonNameAsc().forEach(System.out::println);

        System.out.println(" - findByCommonNameLike - ");
        this.speciesRepository.findByCommonNameLike("Chien").forEach(System.out::println);

        System.out.println(" --- PersonRepository tests --- ");

        System.out.println(" - findByLastnameOrFirstname - ");
        this.personRepository.findByLastnameOrFirstname("Doe", "John").forEach(System.out::println);

        System.out.println(" - findByAgeGreaterThanEqual - ");
        this.personRepository.findByAgeGreaterThanEqual(30).forEach(System.out::println);

        System.out.println(" - findByAgeBetween - ");
        this.personRepository.findByAgeBetween(20, 30).forEach(System.out::println);

        Animal animal = this.animalRepository.findById(1).get();
        System.out.println(" - findByAnimal - ");
        this.personRepository.findByAnimal(animal).forEach(System.out::println);


        System.out.println(" --- AnimalRepository tests --- ");
        Species species = this.speciesRepository.findById(1).get();
        System.out.println(" - findBySpecies - ");
        this.animalRepository.findBySpecies(species).forEach(System.out::println);

        System.out.println(" - findByColorIn - ");

        this.animalRepository.findByColorIn(List.of("Blanc", "Noir")).forEach(System.out::println);


        System.out.println(" - countBySex - ");
        System.out.println(this.animalRepository.countBySex("M"));


        System.out.println(" - existsByAnimal - ");
        System.out.println(this.animalRepository.existsByAnimal(animal));

    }
}
