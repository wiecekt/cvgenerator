package com.tt.test.service.impl;

import com.tt.test.domain.UserEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.UserEntityRepository;
import com.tt.test.service.UserEntityService;
import com.tt.test.service.dto.UserEntityDTO;
import com.tt.test.service.mapper.UserEntityMapper;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    private UserEntityRepository userEntityRepository;
    private EmployeeEntityRepository employeeEntityRepository;
    private UserEntityMapper userEntityMapper;

    @Autowired
    public UserEntityServiceImpl(UserEntityRepository userEntityRepository, EmployeeEntityRepository employeeEntityRepository) {
        this.userEntityRepository = userEntityRepository;
        this.employeeEntityRepository = employeeEntityRepository;
        this.userEntityMapper = Selma.builder(UserEntityMapper.class).build();
    }

    @Override
    public void create(UserEntity obj) {
        userEntityRepository.save(obj);
    }

    @Override
    public void create(UserEntityDTO userEntityDTO) {
        UserEntity userEntity = userEntityMapper.asUserEntity(userEntityDTO);
        userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userEntityRepository.findOne(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    @Override
    public void updateUser(Long id, UserEntityDTO userEntityDTO) {
        //sprawdz czy istnieje
        UserEntity userById = getUserById(id);
        UserEntity userEntity = userEntityMapper.asUserEntity(userEntityDTO);
        userEntity.setId(userById.getId());

        userEntityRepository.save(userEntity);
    }

    @Override
    public void deleteUserById(Long id) {
        userEntityRepository.delete(id);
    }
}
