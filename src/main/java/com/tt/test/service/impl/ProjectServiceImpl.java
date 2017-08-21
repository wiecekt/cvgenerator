package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.ProjectEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.ProjectEntityRepository;
import com.tt.test.service.ProjectService;
import com.tt.test.service.dto.ProjectDTO;
import com.tt.test.service.mapper.ProjectMapper;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectEntityRepository projectEntityRepository;
    private EmployeeEntityRepository employeeEntityRepository;
    private ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectEntityRepository projectEntityRepository, EmployeeEntityRepository employeeEntityRepository) {
        this.projectEntityRepository = projectEntityRepository;
        this.employeeEntityRepository = employeeEntityRepository;
        this.projectMapper = Selma.builder(ProjectMapper.class).build();
    }

    @Override
    public void create(ProjectEntity obj) {
        projectEntityRepository.save(obj);
    }

    @Override
    public ProjectEntity create(ProjectDTO projectDTO) {
        EmployeeEntity employeeById = findEmployeeById(projectDTO.getEmployeeId());
        ProjectEntity projectEntity = projectMapper.asProjectEntity(projectDTO);
        projectEntity.setEmployeeEntity(employeeById);

        return projectEntityRepository.save(projectEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findOne(id);
        if (employeeEntity == null)
            throw new ResourceNotFoundException("Employee with id = " + id + " was not found.");
        return employeeEntity;
    }

    @Override
    public ProjectEntity getProjectById(Long id) {
        ProjectEntity projectEntity = projectEntityRepository.findOne(id);
        if (projectEntity == null)
            throw new ResourceNotFoundException("Project with id = " + id + " was not found.");
        return projectEntity;
    }

    @Override
    public List<ProjectEntity> getAllProjects() {
        return projectEntityRepository.findAll();
    }

    @Override
    public ProjectEntity updateProject(Long id, ProjectDTO projectDTO) {
        ProjectEntity projectEntity = projectMapper.asProjectEntity(projectDTO);
        if (checkIfExists(id))
            projectEntity.setId(id);

        EmployeeEntity employeeById = findEmployeeById(projectDTO.getEmployeeId());
        projectEntity.setEmployeeEntity(employeeById);

        return projectEntityRepository.save(projectEntity);
    }

    @Override
    public void deleteProjectById(Long id) {
        if (checkIfExists(id))
            projectEntityRepository.delete(id);
    }

    @Override
    public boolean checkIfExists(Long id) {
        if (!projectEntityRepository.exists(id))
            throw new ResourceNotFoundException("Project with id = " + id + " was not found.");
        return true;
    }
}
