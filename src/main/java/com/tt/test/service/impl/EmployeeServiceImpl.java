package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeEntityRepository employeeEntityRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeEntityRepository employeeEntityRepository) {
        this.employeeEntityRepository = employeeEntityRepository;
    }

    @Override
    public void create(EmployeeEntity obj) {
        employeeEntityRepository.save(obj);
    }
}
