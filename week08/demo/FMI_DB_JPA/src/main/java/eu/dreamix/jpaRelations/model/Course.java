package eu.dreamix.jpaRelations.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public Course() {}
}