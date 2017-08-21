package com.tt.test.web.rest;

import com.tt.test.domain.AbilityEntity;
import com.tt.test.service.AbilityService;
import com.tt.test.service.dto.AbilityDTO;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing AbilityEntity.
 */
@RestController
@RequestMapping("/api")
public class AbilityEntityResource {

    private final Logger log = LoggerFactory.getLogger(AbilityEntityResource.class);

    private static final String ENTITY_NAME = "abilityEntity";

    private AbilityService abilityService;

    @Autowired
    public AbilityEntityResource(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping("/abilities/{id}")
    public ResponseEntity<AbilityEntity> getAbility(@PathVariable("id") Long id) throws ResourceNotFoundException {
        AbilityEntity abilityById = abilityService.getAbilityById(id);
        return new ResponseEntity<>(abilityById, HttpStatus.OK);
    }

    @GetMapping("/abilities")
    public ResponseEntity<List<AbilityEntity>> getAllAbilities() {
        List<AbilityEntity> allAbilities = abilityService.getAllAbilities();
        return new ResponseEntity<>(allAbilities, HttpStatus.OK);
    }

    @PostMapping("/abilities")
    public ResponseEntity<AbilityEntity> createAbility(@RequestBody AbilityDTO abilityDTO) {
        AbilityEntity abilityEntity = abilityService.create(abilityDTO);
        return new ResponseEntity<>(abilityEntity, HttpStatus.OK);
    }

    @PutMapping("/abilities/{id}")
    public ResponseEntity<AbilityEntity> updateAbility(@PathVariable("id") Long id, @RequestBody AbilityDTO abilityDTO) {
        AbilityEntity abilityEntity = abilityService.updateAbility(id, abilityDTO);
        return new ResponseEntity<>(abilityEntity, HttpStatus.OK);
    }

    @DeleteMapping("/abilities/{id}")
    public ResponseEntity<String> deleteAbility(@PathVariable("id") Long id) {
        abilityService.deleteAbilityById(id);
        return new ResponseEntity<>("Ability with id = " + id + " was successfully removed.", HttpStatus.OK);
    }

    /*@GetMapping("/ability-entities/{id}")
    @Timed
    public ResponseEntity<AbilityEntity> getAbilityEntity(@PathVariable Long id) {
        log.debug("REST request to get AbilityEntity : {}", id);
        AbilityEntity abilityEntity = abilityEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(abilityEntity));
    }*/


    /**
     * POST  /ability-entities : Create a new abilityEntity.
     *
     * @param abilityEntity the abilityEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new abilityEntity, or with status 400 (Bad Request) if the abilityEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
/*    @PostMapping("/ability-entities")
    @Timed
    public ResponseEntity<AbilityEntity> createAbilityEntity(@RequestBody AbilityEntity abilityEntity) throws URISyntaxException {
        log.debug("REST request to save AbilityEntity : {}", abilityEntity);
        if (abilityEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new abilityEntity cannot already have an ID")).body(null);
        }
        AbilityEntity result = abilityEntityRepository.save(abilityEntity);
        return ResponseEntity.created(new URI("/api/ability-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }*/

    /**
     * PUT  /ability-entities : Updates an existing abilityEntity.
     *
     * @param abilityEntity the abilityEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated abilityEntity,
     * or with status 400 (Bad Request) if the abilityEntity is not valid,
     * or with status 500 (Internal Server Error) if the abilityEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
/*    @PutMapping("/ability-entities")
    @Timed
    public ResponseEntity<AbilityEntity> updateAbilityEntity(@RequestBody AbilityEntity abilityEntity) throws URISyntaxException {
        log.debug("REST request to update AbilityEntity : {}", abilityEntity);
        if (abilityEntity.getId() == null) {
            return createAbilityEntity(abilityEntity);
        }
        AbilityEntity result = abilityEntityRepository.save(abilityEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, abilityEntity.getId().toString()))
            .body(result);
    }*/

    /**
     * GET  /ability-entities : get all the abilityEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of abilityEntities in body
     */
/*    @GetMapping("/ability-entities")
    @Timed
    public List<AbilityEntity> getAllAbilityEntities() {
        log.debug("REST request to get all AbilityEntities");
        return abilityEntityRepository.findAll();
    }*/

    /**
     * GET  /ability-entities/:id : get the "id" abilityEntity.
     *
     * @param id the id of the abilityEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the abilityEntity, or with status 404 (Not Found)
     */
/*    @GetMapping("/ability-entities/{id}")
    @Timed
    public ResponseEntity<AbilityEntity> getAbilityEntity(@PathVariable Long id) {
        log.debug("REST request to get AbilityEntity : {}", id);
        AbilityEntity abilityEntity = abilityEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(abilityEntity));
    }*/

    /**
     * DELETE  /ability-entities/:id : delete the "id" abilityEntity.
     *
     * @param id the id of the abilityEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     */
/*    @DeleteMapping("/ability-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteAbilityEntity(@PathVariable Long id) {
        log.debug("REST request to delete AbilityEntity : {}", id);
        abilityEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }*/
}
