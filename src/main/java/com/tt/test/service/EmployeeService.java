package com.tt.test.service;

import com.tt.test.domain.EducationEntity;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.service.dto.EducationDTO;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.SmallEmployeeDTO;

import java.util.List;

public interface EmployeeService {

    void create(EmployeeEntity obj);
    void create(SmallEmployeeDTO smallEmployeeDTO);
    EmployeeEntity getEmployeeById(Long id);
    List<EmployeeEntity> getAllEmployees();
    void updateEmployee(Long id, SmallEmployeeDTO smallEmployeeDTO);
    void deleteEmployeeById(Long id);
}
