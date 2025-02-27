package fr.epsi.b3devc1.sylvainmjc.bestioles.models;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "login")
    private String login;


    @Column(name = "mdp")
    private String password;

    @Column(name = "active")
    private Byte active;


    @ManyToMany
    @JoinTable(name = "person_animals",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "animals_id"))
    private List<Animal> animals;


    @ManyToMany
    @JoinTable(name = "person_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age='" + age + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
