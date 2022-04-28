package eu.dreamix.jpaRelations.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "my_students")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String family;

    @Column
    private Integer facultyNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details details;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty")
    private Faculty faculty;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> courses;

    public Student() {
    }

    public Student(String name, String family, Integer facultyNumber, Details details, Faculty faculty, Set<Course> courses) {
        this.name = name;
        this.family = family;
        this.facultyNumber = facultyNumber;
        this.details = details;
        this.faculty = faculty;
        this.courses = courses;
    }
}
