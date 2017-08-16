package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.UserEntity;
import com.tt.test.repository.UserEntityRepository;
import com.tt.test.service.UserEntityService;
import com.tt.test.service.dto.SmallEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    private UserEntityRepository userEntityRepository;

    @Autowired
    public UserEntityServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public void create(UserEntity obj) {
        userEntityRepository.save(obj);
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
