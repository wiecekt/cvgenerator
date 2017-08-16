package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.UserEntity;
import com.tt.test.service.dto.UserEntityDTO;

import java.util.List;

public interface UserEntityService {

    void create(UserEntity obj);
    void create(UserEntityDTO userEntityDTO);
    EmployeeEntity findEmployeeById(Long id);
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    void updateUser(Long id, UserEntityDTO userEntityDTO);
    void deleteUserById(Long id);
}
