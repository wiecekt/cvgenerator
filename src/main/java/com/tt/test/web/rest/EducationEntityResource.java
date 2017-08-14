package com.tt.test.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.tt.test.domain.EducationEntity;

import com.tt.test.repository.EducationEntityRepository;
import com.tt.test.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing EducationEntity.
 */
@RestController
@RequestMapping("/api")
public class EducationEntityResource {

    private final Logger log = LoggerFactory.getLogger(EducationEntityResource.class);

    private static final String ENTITY_NAME = "educationEntity";

    private final EducationEntityRepository educationEntityRepository;

    public EducationEntityResource(EducationEntityRepository educationEntityRepository) {
        this.educationEntityRepository = educationEntityRepository;
    }

    /**
     * POST  /education-entities : Create a new educationEntity.
     *
     * @param educationEntity the educationEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new educationEntity, or with status 400 (Bad Request) if the educationEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/education-entities")
    @Timed
    public ResponseEntity<EducationEntity> createEducationEntity(@RequestBody EducationEntity educationEntity) throws URISyntaxException {
        log.debug("REST request to save EducationEntity : {}", educationEntity);
        if (educationEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new educationEntity cannot already have an ID")).body(null);
        }
        EducationEntity result = educationEntityRepository.save(educationEntity);
        return ResponseEntity.created(new URI("/api/education-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /education-entities : Updates an existing educationEntity.
     *
     * @param educationEntity the educationEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated educationEntity,
     * or with status 400 (Bad Request) if the educationEntity is not valid,
     * or with status 500 (Internal Server Error) if the educationEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/education-entities")
    @Timed
    public ResponseEntity<EducationEntity> updateEducationEntity(@RequestBody EducationEntity educationEntity) throws URISyntaxException {
        log.debug("REST request to update EducationEntity : {}", educationEntity);
        if (educationEntity.getId() == null) {
            return createEducationEntity(educationEntity);
        }
        EducationEntity result = educationEntityRepository.save(educationEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, educationEntity.getId().toString()))
            .body(result);
    }

    /**
     * GET  /education-entities : get all the educationEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of educationEntities in body
     */
    @GetMapping("/education-entities")
    @Timed
    public List<EducationEntity> getAllEducationEntities() {
        log.debug("REST request to get all EducationEntities");
        return educationEntityRepository.findAll();
    }

    /**
     * GET  /education-entities/:id : get the "id" educationEntity.
     *
     * @param id the id of the educationEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the educationEntity, or with status 404 (Not Found)
     */
    @GetMapping("/education-entities/{id}")
    @Timed
    public ResponseEntity<EducationEntity> getEducationEntity(@PathVariable Long id) {
        log.debug("REST request to get EducationEntity : {}", id);
        EducationEntity educationEntity = educationEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(educationEntity));
    }

    /**
     * DELETE  /education-entities/:id : delete the "id" educationEntity.
     *
     * @param id the id of the educationEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/education-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteEducationEntity(@PathVariable Long id) {
        log.debug("REST request to delete EducationEntity : {}", id);
        educationEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
