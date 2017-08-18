package com.tt.test.web.rest;

import com.tt.test.domain.UserEntity;
import com.tt.test.service.UserEntityService;
import com.tt.test.service.dto.UserEntityDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing UserEntity.
 */
@RestController
@RequestMapping("/api")
public class UserEntityResource {

    private final Logger log = LoggerFactory.getLogger(UserEntityResource.class);

    private static final String ENTITY_NAME = "userEntity";

   private UserEntityService userEntityService;

   @Autowired
    public UserEntityResource(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/users/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
        return userEntityService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userEntityService.getAllUsers();
    }

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntityDTO userEntityDTO) {
        return userEntityService.create(userEntityDTO);
    }

    @PutMapping("/users/{id}")
    public UserEntity updateUser(@PathVariable("id") Long id, @RequestBody UserEntityDTO userEntityDTO) {
        return userEntityService.updateUser(id, userEntityDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userEntityService.deleteUserById(id);
    }

   /*
    *//**
     * POST  /user-entities : Create a new userEntity.
     *
     * @param userEntity the userEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userEntity, or with status 400 (Bad Request) if the userEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PostMapping("/user-entities")
    @Timed
    public ResponseEntity<UserEntity> createUserEntity(@RequestBody UserEntity userEntity) throws URISyntaxException {
        log.debug("REST request to save UserEntity : {}", userEntity);
        if (userEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new userEntity cannot already have an ID")).body(null);
        }
        UserEntity result = userEntityRepository.save(userEntity);
        return ResponseEntity.created(new URI("/api/user-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    *//**
     * PUT  /user-entities : Updates an existing userEntity.
     *
     * @param userEntity the userEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userEntity,
     * or with status 400 (Bad Request) if the userEntity is not valid,
     * or with status 500 (Internal Server Error) if the userEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PutMapping("/user-entities")
    @Timed
    public ResponseEntity<UserEntity> updateUserEntity(@RequestBody UserEntity userEntity) throws URISyntaxException {
        log.debug("REST request to update UserEntity : {}", userEntity);
        if (userEntity.getId() == null) {
            return createUserEntity(userEntity);
        }
        UserEntity result = userEntityRepository.save(userEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userEntity.getId().toString()))
            .body(result);
    }

    *//**
     * GET  /user-entities : get all the userEntities.
     *
     * @param filter the filter of the request
     * @return the ResponseEntity with status 200 (OK) and the list of userEntities in body
     *//*
    @GetMapping("/user-entities")
    @Timed
    public List<UserEntity> getAllUserEntities(@RequestParam(required = false) String filter) {
        if ("employeeentity-is-null".equals(filter)) {
            log.debug("REST request to get all UserEntitys where employeeEntity is null");
            return StreamSupport
                .stream(userEntityRepository.findAll().spliterator(), false)
                .filter(userEntity -> userEntity.getEmployeeEntity() == null)
                .collect(Collectors.toList());
        }
        log.debug("REST request to get all UserEntities");
        return userEntityRepository.findAll();
    }

    *//**
     * GET  /user-entities/:id : get the "id" userEntity.
     *
     * @param id the id of the userEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the userEntity, or with status 404 (Not Found)
     *//*
    @GetMapping("/user-entities/{id}")
    @Timed
    public ResponseEntity<UserEntity> getUserEntity(@PathVariable Long id) {
        log.debug("REST request to get UserEntity : {}", id);
        UserEntity userEntity = userEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(userEntity));
    }

    *//**
     * DELETE  /user-entities/:id : delete the "id" userEntity.
     *
     * @param id the id of the userEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     *//*
    @DeleteMapping("/user-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteUserEntity(@PathVariable Long id) {
        log.debug("REST request to delete UserEntity : {}", id);
        userEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }*/
}
