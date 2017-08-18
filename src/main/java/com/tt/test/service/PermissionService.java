package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.PermissionEntity;
import com.tt.test.service.dto.PermissionDTO;

import java.util.List;

public interface PermissionService {

    void create(PermissionEntity obj);
    PermissionEntity create(PermissionDTO permissionDTO);
    EmployeeEntity findEmployeeById(Long id);
    PermissionEntity getPermissionById(Long id);
    List<PermissionEntity> getAllPermissions();
    PermissionEntity updatePermission(Long id, PermissionDTO permissionDTO);
    void deletePermissionById(Long id);
}
