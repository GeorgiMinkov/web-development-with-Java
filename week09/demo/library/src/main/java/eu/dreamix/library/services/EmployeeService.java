package eu.dreamix.library.services;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import eu.dreamix.library.dtos.EmployeeDTO;
import eu.dreamix.library.models.enums.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.dreamix.library.models.Employee;
import eu.dreamix.library.repositories.IEmployeeRepository;

@Service
public class EmployeeService {

    private static final String NOT_FOUND_MESSAGE = "Employee is not found.";

    @Autowired
    private IEmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        if (employeeRepository.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName()).isEmpty()) {
            throw new IllegalArgumentException(String.format("%s %s already exists.",
                    employee.getFirstName(), employee.getLastName())
            );
        }

        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        LinkedList<Employee> allEmployees = new LinkedList<>();
        employeeRepository.findAll().forEach(allEmployees::add);
        return allEmployees;
    }

    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(NOT_FOUND_MESSAGE));
    }

    public void updateEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getId())) {
            throw new NoSuchElementException(NOT_FOUND_MESSAGE);
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee(long id) {
        if (!employeeRepository.existsById(id)) {
            throw new NoSuchElementException(NOT_FOUND_MESSAGE);
        }

        employeeRepository.deleteById(id);
    }

    public Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Employee toEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();

        employee.setFirstName(dto.firstName);
        employee.setLastName(dto.lastName);
        employee.setPosition(Position.valueOf(dto.position));

        return employee;
    }
}
