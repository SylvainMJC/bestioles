package fr.epsi.b3devc1.sylvainmjc.bestioles.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "color")
    private String color;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @ManyToOne
    @JoinColumn(name = "species_id")
    Species species;

    @ManyToMany(mappedBy = "animals")
    private List<Person> persons;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", color=" + color + '\'' +
                ", name=" + name + '\'' +
                ", species=" + species.getCommonName();
    }
}
