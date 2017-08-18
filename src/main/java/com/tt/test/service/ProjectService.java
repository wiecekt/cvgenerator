package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.ProjectEntity;
import com.tt.test.service.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    void create(ProjectEntity obj);
    ProjectEntity create(ProjectDTO projectDTO);
    EmployeeEntity findEmployeeById(Long id);
    ProjectEntity getProjectById(Long id);
    List<ProjectEntity> getAllProjects();
    ProjectEntity updateProject(Long id, ProjectDTO projectDTO);
    void deleteProjectById(Long id);
}
