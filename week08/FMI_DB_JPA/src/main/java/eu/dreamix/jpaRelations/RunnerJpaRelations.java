package eu.dreamix.jpaRelations;

import eu.dreamix.jpaRelations.model.Course;
import eu.dreamix.jpaRelations.model.Details;
import eu.dreamix.jpaRelations.model.Faculty;
import eu.dreamix.jpaRelations.model.Student;
import eu.dreamix.jpaRelations.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class RunnerJpaRelations implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;

    @Transactional
    @Override
    public void run(String... args) {

        Faculty fmi = new Faculty("FMI");

        Course algebra = new Course("Algebra");
        Course geometry = new Course("Geometry");
        Course oop = new Course("OOP");
        Course web = new Course("WEB");

        Details details = new Details("0888 888 888", "foo@bar.org");
        Set<Course> courses = new HashSet<>();
        courses.add(algebra);
        courses.add(geometry);

        Student myStudent = new Student("Ivan", "Petrov", 14162, details, fmi, courses);
        repository.save(myStudent);

        Details details2 = new Details("0888 999 777", "john@doe.org");
        Set<Course> courses2 = new HashSet<>();
        courses2.add(oop);
        courses2.add(web);
        courses2.add(geometry);
        Student myStudent2 = new Student("Mark", "Twain", 14163, details2, fmi, courses2);
        repository.save(myStudent2);
    }
}