package com.tt.test.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.tt.test.domain.DictionaryEntity;
import com.tt.test.repository.DictionaryEntityRepository;
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
 * REST controller for managing DictionaryEntity.
 */
@RestController
@RequestMapping("/api")
public class DictionaryEntityResource {

    private final Logger log = LoggerFactory.getLogger(DictionaryEntityResource.class);

    private static final String ENTITY_NAME = "dictionaryEntity";

    private final DictionaryEntityRepository dictionaryEntityRepository;

    public DictionaryEntityResource(DictionaryEntityRepository dictionaryEntityRepository) {
        this.dictionaryEntityRepository = dictionaryEntityRepository;
    }

    @GetMapping("/dictionary")
    public List<DictionaryEntity> getDictionaryBySection(@RequestParam("section") String section) {
        System.out.println(section);
        return dictionaryEntityRepository.findDictionariesBySection(section.toUpperCase());
    }

    /**
     * POST  /dictionary-entities : Create a new dictionaryEntity.
     *
     * @param dictionaryEntity the dictionaryEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new dictionaryEntity, or with status 400 (Bad Request) if the dictionaryEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/dictionary-entities")
    @Timed
    public ResponseEntity<DictionaryEntity> createDictionaryEntity(@RequestBody DictionaryEntity dictionaryEntity) throws URISyntaxException {
        log.debug("REST request to save DictionaryEntity : {}", dictionaryEntity);
        if (dictionaryEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new dictionaryEntity cannot already have an ID")).body(null);
        }
        DictionaryEntity result = dictionaryEntityRepository.save(dictionaryEntity);
        return ResponseEntity.created(new URI("/api/dictionary-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /dictionary-entities : Updates an existing dictionaryEntity.
     *
     * @param dictionaryEntity the dictionaryEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated dictionaryEntity,
     * or with status 400 (Bad Request) if the dictionaryEntity is not valid,
     * or with status 500 (Internal Server Error) if the dictionaryEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/dictionary-entities")
    @Timed
    public ResponseEntity<DictionaryEntity> updateDictionaryEntity(@RequestBody DictionaryEntity dictionaryEntity) throws URISyntaxException {
        log.debug("REST request to update DictionaryEntity : {}", dictionaryEntity);
        if (dictionaryEntity.getId() == null) {
            return createDictionaryEntity(dictionaryEntity);
        }
        DictionaryEntity result = dictionaryEntityRepository.save(dictionaryEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, dictionaryEntity.getId().toString()))
            .body(result);
    }

    /**
     * GET  /dictionary-entities : get all the dictionaryEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of dictionaryEntities in body
     */
    @GetMapping("/dictionary-entities")
    @Timed
    public List<DictionaryEntity> getAllDictionaryEntities() {
        log.debug("REST request to get all DictionaryEntities");
        return dictionaryEntityRepository.findAll();
    }

    /**
     * GET  /dictionary-entities/:id : get the "id" dictionaryEntity.
     *
     * @param id the id of the dictionaryEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the dictionaryEntity, or with status 404 (Not Found)
     */
    @GetMapping("/dictionary-entities/{id}")
    @Timed
    public ResponseEntity<DictionaryEntity> getDictionaryEntity(@PathVariable Long id) {
        log.debug("REST request to get DictionaryEntity : {}", id);
        DictionaryEntity dictionaryEntity = dictionaryEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(dictionaryEntity));
    }

    /**
     * DELETE  /dictionary-entities/:id : delete the "id" dictionaryEntity.
     *
     * @param id the id of the dictionaryEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/dictionary-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteDictionaryEntity(@PathVariable Long id) {
        log.debug("REST request to delete DictionaryEntity : {}", id);
        dictionaryEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
