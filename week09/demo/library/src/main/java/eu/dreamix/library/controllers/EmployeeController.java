package eu.dreamix.library.controllers;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eu.dreamix.library.dtos.EmployeeDTO;
import eu.dreamix.library.services.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployeeDTOs() {
        return employeeService.getAllEmployees()
                .stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public EmployeeDTO getEmployeeDTO(@PathVariable("id") long id) {
        return new EmployeeDTO(employeeService.getEmployee(id));
    }

    @PostMapping
    public void addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeService.toEmployee(employeeDTO));
    }

    @PutMapping
    public void updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeService.toEmployee(employeeDTO));
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
    }

}

