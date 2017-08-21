package com.tt.test.service;

import com.tt.test.domain.UserEntity;
import com.tt.test.service.dto.UserEntityDTO;

import java.util.List;

public interface UserEntityService {

    UserEntity create(UserEntity obj);
    UserEntity create(UserEntityDTO userEntityDTO);
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    UserEntity updateUser(Long id, UserEntityDTO userEntityDTO);
    void deleteUserById(Long id);
    boolean checkIfExists(Long id);
}
