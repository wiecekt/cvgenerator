package com.tt.test.web.rest;

import com.tt.test.domain.PermissionEntity;
import com.tt.test.service.PermissionService;
import com.tt.test.service.dto.PermissionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing PermissionEntity.
 */
@RestController
@RequestMapping("/api")
public class PermissionEntityResource {

    private final Logger log = LoggerFactory.getLogger(PermissionEntityResource.class);

    private static final String ENTITY_NAME = "permissionEntity";

    private PermissionService permissionService;

    @Autowired
    public PermissionEntityResource(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/permissions/{id}")
    public PermissionEntity getPermission(@PathVariable("id") Long id) {
        return permissionService.getPermissionById(id);
    }

    @GetMapping("/permissions")
    public List<PermissionEntity> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @PostMapping("/permissions")
    public PermissionEntity createPermission(@RequestBody PermissionDTO permissionDTO) {
        return permissionService.create(permissionDTO);
    }

    @PutMapping("/permissions/{id}")
    public PermissionEntity updatePermission(@PathVariable("id") Long id, @RequestBody PermissionDTO permissionDTO) {
        return permissionService.updatePermission(id, permissionDTO);
    }

    @DeleteMapping("/permissions/{id}")
    public void deletePermission(@PathVariable("id") Long id) {
        permissionService.deletePermissionById(id);
    }

    /*
    *//**
     * POST  /permission-entities : Create a new permissionEntity.
     *
     * @param permissionEntity the permissionEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new permissionEntity, or with status 400 (Bad Request) if the permissionEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PostMapping("/permission-entities")
    @Timed
    public ResponseEntity<PermissionEntity> createPermissionEntity(@RequestBody PermissionEntity permissionEntity) throws URISyntaxException {
        log.debug("REST request to save PermissionEntity : {}", permissionEntity);
        if (permissionEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new permissionEntity cannot already have an ID")).body(null);
        }
        PermissionEntity result = permissionEntityRepository.save(permissionEntity);
        return ResponseEntity.created(new URI("/api/permission-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    *//**
     * PUT  /permission-entities : Updates an existing permissionEntity.
     *
     * @param permissionEntity the permissionEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated permissionEntity,
     * or with status 400 (Bad Request) if the permissionEntity is not valid,
     * or with status 500 (Internal Server Error) if the permissionEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PutMapping("/permission-entities")
    @Timed
    public ResponseEntity<PermissionEntity> updatePermissionEntity(@RequestBody PermissionEntity permissionEntity) throws URISyntaxException {
        log.debug("REST request to update PermissionEntity : {}", permissionEntity);
        if (permissionEntity.getId() == null) {
            return createPermissionEntity(permissionEntity);
        }
        PermissionEntity result = permissionEntityRepository.save(permissionEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, permissionEntity.getId().toString()))
            .body(result);
    }

    *//**
     * GET  /permission-entities : get all the permissionEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of permissionEntities in body
     *//*
    @GetMapping("/permission-entities")
    @Timed
    public List<PermissionEntity> getAllPermissionEntities() {
        log.debug("REST request to get all PermissionEntities");
        return permissionEntityRepository.findAll();
    }

    *//**
     * GET  /permission-entities/:id : get the "id" permissionEntity.
     *
     * @param id the id of the permissionEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the permissionEntity, or with status 404 (Not Found)
     *//*
    @GetMapping("/permission-entities/{id}")
    @Timed
    public ResponseEntity<PermissionEntity> getPermissionEntity(@PathVariable Long id) {
        log.debug("REST request to get PermissionEntity : {}", id);
        PermissionEntity permissionEntity = permissionEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(permissionEntity));
    }

    *//**
     * DELETE  /permission-entities/:id : delete the "id" permissionEntity.
     *
     * @param id the id of the permissionEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     *//*
    @DeleteMapping("/permission-entities/{id}")
    @Timed
    public ResponseEntity<Void> deletePermissionEntity(@PathVariable Long id) {
        log.debug("REST request to delete PermissionEntity : {}", id);
        permissionEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }*/
}
