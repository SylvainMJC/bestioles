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
//        animalRepository.findAll().forEach(System.out::println);
//
//        System.out.println(" --- Persons --- ");
//        personRepository.findAll().forEach(System.out::println);
//
//        System.out.println(" --- Roles --- ");
//        roleRepository.findAll().forEach(System.out::println);
//
//        System.out.println(" --- Scpecies --- ");
//        speciesRepository.findAll().forEach(System.out::println);

        // TP 4 & 5

//        System.out.println(" --- SpeciesRepository tests --- ");
//        System.out.println(" - findFirstByCommonName - ");
//        System.out.println(speciesRepository.findFirstByCommonName("Chien"));
//
//        System.out.println(" - findByLatinNameContainingIgnoreCase - ");
//        speciesRepository.findByLatinNameContainingIgnoreCase("canis").forEach(System.out::println);
//
//        System.out.println(" - findAllOrderByCommonNameAsc - ");
//        speciesRepository.findAllOrderByCommonNameAsc().forEach(System.out::println);
//
//        System.out.println(" - findByCommonNameLike - ");
//        speciesRepository.findByCommonNameLike("Chien").forEach(System.out::println);
//
//        System.out.println(" --- PersonRepository tests --- ");
//
//        System.out.println(" - findByLastnameOrFirstname - ");
//        personRepository.findByLastnameOrFirstname("Doe", "John").forEach(System.out::println);
//
//        System.out.println(" - findByAgeGreaterThanEqual - ");
//        personRepository.findByAgeGreaterThanEqual(30).forEach(System.out::println);
//
//        System.out.println(" - findByAgeBetween - ");
//        personRepository.findByAgeBetween(20, 30).forEach(System.out::println);
//
//        Animal animal = animalRepository.findById(1).get();
//        System.out.println(" - findByAnimal - ");
//        personRepository.findByAnimal(animal).forEach(System.out::println);
//
//        System.out.println(" --- AnimalRepository tests --- ");
//        Species species = speciesRepository.findById(1).get();
//        System.out.println(" - findBySpecies - ");
//        animalRepository.findBySpecies(species).forEach(System.out::println);
//
//        System.out.println(" - findByColorIn - ");
//        animalRepository.findByColorIn(List.of("Blanc", "Noir")).forEach(System.out::println);
//
//        System.out.println(" - countBySex - ");
//        System.out.println(animalRepository.countBySex("M"));
//
//        System.out.println(" - existsByAnimal - ");
//        System.out.println(animalRepository.existsByAnimal(animal));


        // TP6

        System.out.println(" --- PersonRepositoryCustom tests --- ");
        personRepository.generateRandomPersons(3).forEach(System.out::println);

        personRepository.findAll().forEach(System.out::println);
        personRepository.deletePersonsWithoutAnimals();
        personRepository.findAll().forEach(System.out::println);
    }
}
