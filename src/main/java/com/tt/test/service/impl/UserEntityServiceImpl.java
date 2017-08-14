package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.UserEntity;
import com.tt.test.repository.UserEntityRepository;
import com.tt.test.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
