package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.PermissionEntity;
import com.tt.test.repository.PermissionEntityRepository;
import com.tt.test.service.PermissionService;
import com.tt.test.service.dto.PermissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void create(PermissionDTO permissionDTO) {

    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return null;
    }

    @Override
    public PermissionEntity getPermissionById(Long id) {
        return null;
    }

    @Override
    public List<PermissionEntity> getAllPermissions() {
        return null;
    }

    @Override
    public void updatePermission(Long id, PermissionDTO permissionDTO) {

    }

    @Override
    public void deletePermissionById(Long id) {

    }
}
