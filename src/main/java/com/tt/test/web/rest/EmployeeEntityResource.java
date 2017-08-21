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

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing EmployeeEntity.
 */
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
/*
    *//**
     * POST  /employee-entities : Create a new employeeEntity.
     *
     * @param employeeEntity the employeeEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new employeeEntity, or with status 400 (Bad Request) if the employeeEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PostMapping("/employee-entities")
    @Timed
    public ResponseEntity<EmployeeEntity> createEmployeeEntity(@RequestBody EmployeeEntity employeeEntity) throws URISyntaxException {
        log.debug("REST request to save EmployeeEntity : {}", employeeEntity);
        if (employeeEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new employeeEntity cannot already have an ID")).body(null);
        }
        EmployeeEntity result = employeeEntityRepository.save(employeeEntity);
        return ResponseEntity.created(new URI("/api/employee-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    *//**
     * PUT  /employee-entities : Updates an existing employeeEntity.
     *
     * @param employeeEntity the employeeEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated employeeEntity,
     * or with status 400 (Bad Request) if the employeeEntity is not valid,
     * or with status 500 (Internal Server Error) if the employeeEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PutMapping("/employee-entities")
    @Timed
    public ResponseEntity<EmployeeEntity> updateEmployeeEntity(@RequestBody EmployeeEntity employeeEntity) throws URISyntaxException {
        log.debug("REST request to update EmployeeEntity : {}", employeeEntity);
        if (employeeEntity.getId() == null) {
            return createEmployeeEntity(employeeEntity);
        }
        EmployeeEntity result = employeeEntityRepository.save(employeeEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, employeeEntity.getId().toString()))
            .body(result);
    }

    *//**
     * GET  /employee-entities : get all the employeeEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of employeeEntities in body
     *//*
    @GetMapping("/employee-entities")
    @Timed
    public List<EmployeeEntity> getAllEmployeeEntities() {
        log.debug("REST request to get all EmployeeEntities");
        return employeeEntityRepository.findAll();
    }

    *//**
     * GET  /employee-entities/:id : get the "id" employeeEntity.
     *
     * @param id the id of the employeeEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the employeeEntity, or with status 404 (Not Found)
     *//*
    @GetMapping("/employee-entities/{id}")
    @Timed
    public ResponseEntity<EmployeeEntity> getEmployeeEntity(@PathVariable Long id) {
        log.debug("REST request to get EmployeeEntity : {}", id);
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(employeeEntity));
    }

    *//**
     * DELETE  /employee-entities/:id : delete the "id" employeeEntity.
     *
     * @param id the id of the employeeEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     *//*
    @DeleteMapping("/employee-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteEmployeeEntity(@PathVariable Long id) {
        log.debug("REST request to delete EmployeeEntity : {}", id);
        employeeEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }*/
}
