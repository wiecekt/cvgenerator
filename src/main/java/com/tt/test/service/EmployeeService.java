package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.BasicEmployeeDTO;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.SearchEmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity create(EmployeeEntity obj);
    EmployeeEntity create(BasicEmployeeDTO basicEmployeeDTO);
    EmployeeEntity getEmployeeById(Long id);
    List<EmployeeEntity> getAllEmployees();
    List<EmployeeEntity> searchEmployees(SearchEmployeeDTO searchEmployeeDTO);
    EmployeeEntity updateEmployee(Long id, BasicEmployeeDTO basicEmployeeDTO);
    void deleteEmployeeById(Long id);

    void createTest(EmployeeDTO employeeDTO);
}
