package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.UserEntity;
import com.tt.test.service.dto.SmallEmployeeDTO;

import java.util.List;

public interface UserEntityService {

    void create(UserEntity obj);
    void create(SmallEmployeeDTO smallEmployeeDTO);
    //EmployeeEntity findEmployeeById(Long id);
    EmployeeEntity getEmployeeById(Long id);
    List<EmployeeEntity> getAllEmployees();
    void updateEmployee(Long id, SmallEmployeeDTO smallEmployeeDTO);
    void deleteEmployeeById(Long id);
}
