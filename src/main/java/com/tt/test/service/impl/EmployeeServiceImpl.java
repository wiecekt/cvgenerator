package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.service.EmployeeService;
import com.tt.test.service.dto.SmallEmployeeDTO;
import com.tt.test.service.mapper.EmployeeMapper;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeEntityRepository employeeEntityRepository;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeEntityRepository employeeEntityRepository) {
        this.employeeEntityRepository = employeeEntityRepository;
        this.employeeMapper = Selma.builder(EmployeeMapper.class).build();
    }

    @Override
    public void create(EmployeeEntity obj) {
        employeeEntityRepository.save(obj);
    }

    @Override
    public void create(SmallEmployeeDTO smallEmployeeDTO) {
        EmployeeEntity employeeEntity = employeeMapper.asEmployeeEntity(smallEmployeeDTO);
        employeeEntityRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeEntityRepository.findOne(id);
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeEntityRepository.findAll();
    }

    @Override
    public void updateEmployee(Long id, SmallEmployeeDTO smallEmployeeDTO) {
        EmployeeEntity employeeById = getEmployeeById(id);
        EmployeeEntity employeeEntity = employeeMapper.asEmployeeEntity(smallEmployeeDTO);
        employeeEntity.setId(employeeById.getId());

        employeeEntityRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeEntityRepository.delete(id);
    }
}
