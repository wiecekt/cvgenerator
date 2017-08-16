package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.ProjectEntity;
import com.tt.test.repository.EmployeeEntityRepository;
import com.tt.test.repository.ProjectEntityRepository;
import com.tt.test.service.ProjectService;
import com.tt.test.service.dto.ProjectDTO;
import com.tt.test.service.mapper.ProjectMapper;
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
    public void create(ProjectDTO projectDTO) {
        EmployeeEntity employeeById = findEmployeeById(projectDTO.getEmployeeId());
        ProjectEntity projectEntity = projectMapper.asProjectEntity(projectDTO);
        projectEntity.setEmployeeEntity(employeeById);

        projectEntityRepository.save(projectEntity);
    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return employeeEntityRepository.findOne(id);
    }

    @Override
    public ProjectEntity getProjectById(Long id) {
        return projectEntityRepository.findOne(id);
    }

    @Override
    public List<ProjectEntity> getAllProjects() {
        return projectEntityRepository.findAll();
    }

    @Override
    public void updateProject(Long id, ProjectDTO projectDTO) {
        //sprawdz czy istnieje
        ProjectEntity projectById = getProjectById(id);
        ProjectEntity projectEntity = projectMapper.asProjectEntity(projectDTO);
        projectEntity.setId(projectById.getId());

        EmployeeEntity employeeById = findEmployeeById(projectDTO.getEmployeeId());
        projectEntity.setEmployeeEntity(employeeById);

        projectEntityRepository.save(projectEntity);
    }

    @Override
    public void deleteProjectById(Long id) {
        projectEntityRepository.delete(id);
    }
}
