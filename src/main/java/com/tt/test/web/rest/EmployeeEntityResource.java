package com.tt.test.web.rest;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.EmployeeService;
import com.tt.test.service.dto.BasicEmployeeDTO;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.SearchEmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeEntityResource {

    private final Logger log = LoggerFactory.getLogger(EmployeeEntityResource.class);

    private static final String ENTITY_NAME = "employeeEntity";

    private EmployeeService employeeService;

    @Autowired
    public EmployeeEntityResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable("id") Long id) {
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody BasicEmployeeDTO basicEmployeeDTO) {
        EmployeeEntity employeeEntity = employeeService.create(basicEmployeeDTO);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @PostMapping("/employees-search")
    public ResponseEntity<List<EmployeeEntity>> searchEmployees(@RequestBody SearchEmployeeDTO searchEmployeeDTO) {
        List<EmployeeEntity> employeeEntities = employeeService.searchEmployees(searchEmployeeDTO);
        return new ResponseEntity<>(employeeEntities, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id") Long id, @RequestBody BasicEmployeeDTO basicEmployeeDTO) {
        EmployeeEntity employeeEntity = employeeService.updateEmployee(id, basicEmployeeDTO);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee with id = " + id + " was successfully removed.", HttpStatus.OK);
    }

    @PostMapping("/employees-test")
    public ResponseEntity<EmployeeEntity> createCompleteEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity completeEmployee = employeeService.createCompleteEmployee(employeeDTO);
        return new ResponseEntity<>(completeEmployee, HttpStatus.OK);
    }
}
