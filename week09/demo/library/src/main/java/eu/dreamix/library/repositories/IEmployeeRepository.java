package eu.dreamix.library.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.dreamix.library.models.Employee;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByFirstNameAndLastName(String first, String last);
}
