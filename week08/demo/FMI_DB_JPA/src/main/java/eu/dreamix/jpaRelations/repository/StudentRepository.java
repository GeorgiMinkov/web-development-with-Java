package eu.dreamix.jpaRelations.repository;

import eu.dreamix.jpaRelations.model.Faculty;
import eu.dreamix.jpaRelations.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query()
    List<Student> findStudentByFaculty(Faculty faculty);


}

