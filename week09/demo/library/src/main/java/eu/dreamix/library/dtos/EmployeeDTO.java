package eu.dreamix.library.dtos;

import javax.validation.constraints.NotEmpty;

import eu.dreamix.library.models.Employee;

public class EmployeeDTO {

    public Long id;

    @NotEmpty(message = "First name must not be empty!")
    public String firstName;

    @NotEmpty(message = "Last name must not be empty!")
    public String lastName;

    @NotEmpty(message = "Position must not be empty!")
    public String position;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.id = employee.getId();
        this.position = employee.getPosition().toString();
    }
}
