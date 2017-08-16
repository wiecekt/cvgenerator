package com.tt.test.service.impl;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.ProjectEntity;
import com.tt.test.repository.ProjectEntityRepository;
import com.tt.test.service.ProjectService;
import com.tt.test.service.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectEntityRepository projectEntityRepository;

    @Autowired
    public ProjectServiceImpl(ProjectEntityRepository projectEntityRepository) {
        this.projectEntityRepository = projectEntityRepository;
    }

    @Override
    public void create(ProjectEntity obj) {
        projectEntityRepository.save(obj);
    }

    @Override
    public void create(ProjectDTO projectDTO) {

    }

    @Override
    public EmployeeEntity findEmployeeById(Long id) {
        return null;
    }

    @Override
    public ProjectEntity getProjectById(Long id) {
        return null;
    }

    @Override
    public List<ProjectEntity> getAllProjects() {
        return null;
    }

    @Override
    public void updateProject(Long id, ProjectDTO projectDTO) {

    }

    @Override
    public void deleteProjectById(Long id) {

    }
}
