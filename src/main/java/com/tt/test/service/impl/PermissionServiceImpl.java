package com.tt.test.service.impl;

import com.tt.test.base.IService;
import com.tt.test.domain.PermissionEntity;
import com.tt.test.repository.PermissionEntityRepository;
import com.tt.test.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    private PermissionEntityRepository permissionEntityRepository;

    @Autowired
    public PermissionServiceImpl(PermissionEntityRepository permissionEntityRepository) {
        this.permissionEntityRepository = permissionEntityRepository;
    }

    @Override
    public void create(PermissionEntity obj) {
        permissionEntityRepository.save(obj);
    }
}
