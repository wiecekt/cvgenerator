package com.tt.test.service;

import com.tt.test.domain.EmployeeEntity;
import com.tt.test.domain.PermissionEntity;
import com.tt.test.domain.ProjectEntity;
import com.tt.test.service.dto.PermissionDTO;
import com.tt.test.service.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    void create(ProjectEntity obj);
    void create(ProjectDTO projectDTO);
    EmployeeEntity findEmployeeById(Long id);
    ProjectEntity getProjectById(Long id);
    List<ProjectEntity> getAllProjects();
    void updateProject(Long id, ProjectDTO projectDTO);
    void deleteProjectById(Long id);
}
