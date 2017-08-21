package com.tt.test.web.rest;

import com.tt.test.domain.ProjectEntity;
import com.tt.test.service.ProjectService;
import com.tt.test.service.dto.ProjectDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing ProjectEntity.
 */
@RestController
@RequestMapping("/api")
public class ProjectEntityResource {

    private final Logger log = LoggerFactory.getLogger(ProjectEntityResource.class);

    private static final String ENTITY_NAME = "projectEntity";

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

    /*
    *//**
     * POST  /project-entities : Create a new projectEntity.
     *
     * @param projectEntity the projectEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new projectEntity, or with status 400 (Bad Request) if the projectEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PostMapping("/project-entities")
    @Timed
    public ResponseEntity<ProjectEntity> createProjectEntity(@RequestBody ProjectEntity projectEntity) throws URISyntaxException {
        log.debug("REST request to save ProjectEntity : {}", projectEntity);
        if (projectEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new projectEntity cannot already have an ID")).body(null);
        }
        ProjectEntity result = projectEntityRepository.save(projectEntity);
        return ResponseEntity.created(new URI("/api/project-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    *//**
     * PUT  /project-entities : Updates an existing projectEntity.
     *
     * @param projectEntity the projectEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated projectEntity,
     * or with status 400 (Bad Request) if the projectEntity is not valid,
     * or with status 500 (Internal Server Error) if the projectEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PutMapping("/project-entities")
    @Timed
    public ResponseEntity<ProjectEntity> updateProjectEntity(@RequestBody ProjectEntity projectEntity) throws URISyntaxException {
        log.debug("REST request to update ProjectEntity : {}", projectEntity);
        if (projectEntity.getId() == null) {
            return createProjectEntity(projectEntity);
        }
        ProjectEntity result = projectEntityRepository.save(projectEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, projectEntity.getId().toString()))
            .body(result);
    }

    *//**
     * GET  /project-entities : get all the projectEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of projectEntities in body
     *//*
    @GetMapping("/project-entities")
    @Timed
    public List<ProjectEntity> getAllProjectEntities() {
        log.debug("REST request to get all ProjectEntities");
        return projectEntityRepository.findAll();
    }

    *//**
     * GET  /project-entities/:id : get the "id" projectEntity.
     *
     * @param id the id of the projectEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the projectEntity, or with status 404 (Not Found)
     *//*
    @GetMapping("/project-entities/{id}")
    @Timed
    public ResponseEntity<ProjectEntity> getProjectEntity(@PathVariable Long id) {
        log.debug("REST request to get ProjectEntity : {}", id);
        ProjectEntity projectEntity = projectEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(projectEntity));
    }

    *//**
     * DELETE  /project-entities/:id : delete the "id" projectEntity.
     *
     * @param id the id of the projectEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     *//*
    @DeleteMapping("/project-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteProjectEntity(@PathVariable Long id) {
        log.debug("REST request to delete ProjectEntity : {}", id);
        projectEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }*/
}
