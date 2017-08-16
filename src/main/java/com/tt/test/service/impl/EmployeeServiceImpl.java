package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.EmployeeService;
import com.tt.test.service.dto.EmployeeDTO;
import com.tt.test.service.dto.SmallEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeEntityRepository employeeEntityRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeEntityRepository employeeEntityRepository) {
        this.employeeEntityRepository = employeeEntityRepository;
    }

    @Override
    public void create(EmployeeEntity obj) {

    }

    @Override
    public void create(SmallEmployeeDTO smallEmployeeDTO) {

    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return null;
    }

    @Override
    public void updateEmployee(Long id, SmallEmployeeDTO smallEmployeeDTO) {

    }

    @Override
    public void deleteEmployeeById(Long id) {

    }
}
