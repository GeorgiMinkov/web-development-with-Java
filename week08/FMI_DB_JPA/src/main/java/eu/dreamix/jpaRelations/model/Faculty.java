package eu.dreamix.jpaRelations.model;

import javax.persistence.*;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty() {}
}