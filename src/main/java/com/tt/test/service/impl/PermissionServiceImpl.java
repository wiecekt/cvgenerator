package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.PermissionEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.PermissionEntityRepository;
import com.tt.test.service.PermissionService;
import com.tt.test.service.dto.PermissionDTO;
import com.tt.test.service.mapper.PermissionMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private PermissionEntityRepository permissionEntityRepository;
    private EmployeeEntityRepository employeeEntityRepository;
    private PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionEntityRepository permissionEntityRepository, EmployeeEntityRepository employeeEntityRepository) {
        this.permissionEntityRepository = permissionEntityRepository;
        this.employeeEntityRepository = employeeEntityRepository;
        this.permissionMapper = Selma.builder(PermissionMapper.class).build();
    }

    @Override
    public void create(PermissionEntity obj) {
        permissionEntityRepository.save(obj);
    }

    @Override
    public PermissionEntity create(PermissionDTO permissionDTO) {
        //sprawdz czy istnieje
        EmployeeEntity employeeById = findEmployeeById(permissionDTO.getEmployeeId());
        PermissionEntity permissionEntity = permissionMapper.asPermissionEntity(permissionDTO);
        permissionEntity.setEmployeeEntity(employeeById);

        return permissionEntityRepository.save(permissionEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        if (employeeEntity == null)
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return employeeEntity;
    }

    @Override
    public PermissionEntity getPermissionById(Long id) {
        PermissionEntity permissionEntity = permissionEntityRepository.findOne(id);
        if (permissionEntity == null)
            throw new ResourceNotFoundException("Permission with id = " + id + " was not found.");
        return permissionEntity;
    }

    @Override
    public List<PermissionEntity> getAllPermissions() {
        return permissionEntityRepository.findAll();
    }

    @Override
    public PermissionEntity updatePermission(Long id, PermissionDTO permissionDTO) {
        PermissionEntity permissionEntity = permissionMapper.asPermissionEntity(permissionDTO);
        if (checkIfExists(id))
            permissionEntity.setId(id);

        EmployeeEntity employeeById = findEmployeeById(permissionDTO.getEmployeeId());
        permissionEntity.setEmployeeEntity(employeeById);

        return permissionEntityRepository.save(permissionEntity);
    }

    @Override
    public void deletePermissionById(Long id) {
        if (checkIfExists(id))
            permissionEntityRepository.delete(id);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!permissionEntityRepository.exists(id))
            throw new ResourceNotFoundException("Permission with id = " + id + " was not found.");
        return true;
    }
}
