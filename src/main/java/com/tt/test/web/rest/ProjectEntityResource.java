package com.tt.test.web.rest;

import com.tt.test.domain.ProjectEntity;
import com.tt.test.service.ProjectService;
import com.tt.test.service.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectEntityResource {

    private ProjectService projectService;

    @Autowired
    public ProjectEntityResource(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectEntity> getProject(@PathVariable("id") Long id) {
        ProjectEntity projectEntity = projectService.getProjectById(id);
        return new ResponseEntity<>(projectEntity, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> allProjects = projectService.getAllProjects();
        return new ResponseEntity<>(allProjects, HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectEntity> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectEntity projectEntity = projectService.create(projectDTO);
        return new ResponseEntity<>(projectEntity, HttpStatus.OK);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<ProjectEntity> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDTO projectDTO) {
        ProjectEntity projectEntity = projectService.updateProject(id, projectDTO);
        return new ResponseEntity<>(projectEntity, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProjectById(id);
        return new ResponseEntity<>("Project with id = " + id + " was successfully removed.", HttpStatus.OK);
    }
}
