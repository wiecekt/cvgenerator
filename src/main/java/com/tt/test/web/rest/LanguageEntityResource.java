package com.tt.test.web.rest;

import com.tt.test.domain.LanguageEntity;
import com.tt.test.service.LanguageService;
import com.tt.test.service.dto.LanguageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing LanguageEntity.
 */
@RestController
@RequestMapping("/api")
public class LanguageEntityResource {

    private final Logger log = LoggerFactory.getLogger(LanguageEntityResource.class);

    private static final String ENTITY_NAME = "languageEntity";

    private LanguageService languageService;

    @Autowired
    public LanguageEntityResource(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages/{id}")
    public ResponseEntity<LanguageEntity> getLanguage(@PathVariable("id") Long id) {
        LanguageEntity languageEntity = languageService.getLanguageById(id);
        return new ResponseEntity<>(languageEntity, HttpStatus.OK);
    }

    @GetMapping("/languages")
    public ResponseEntity<List<LanguageEntity>> getAllLanguages() {
        List<LanguageEntity> allLanguages = languageService.getAllLanguages();
        return new ResponseEntity<>(allLanguages, HttpStatus.OK);
    }

    @PostMapping("/languages")
    public ResponseEntity<LanguageEntity> createLanguage(@RequestBody LanguageDTO languageDTO) {
        LanguageEntity languageEntity = languageService.create(languageDTO);
        return new ResponseEntity<>(languageEntity, HttpStatus.OK);
    }

    @PutMapping("/languages/{id}")
    public ResponseEntity<LanguageEntity> updateLanguage(@PathVariable("id") Long id, @RequestBody LanguageDTO languageDTO) {
        LanguageEntity languageEntity = languageService.updateLanguage(id, languageDTO);
        return new ResponseEntity<>(languageEntity, HttpStatus.OK);
    }

    @DeleteMapping("/languages/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable("id") Long id) {
        languageService.deleteLanguageById(id);
        return new ResponseEntity<>("Language with id = " + id + " was successfully removed.", HttpStatus.OK);
    }

    /*
    *//**
     * POST  /language-entities : Create a new languageEntity.
     *
     * @param languageEntity the languageEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new languageEntity, or with status 400 (Bad Request) if the languageEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PostMapping("/language-entities")
    @Timed
    public ResponseEntity<LanguageEntity> createLanguageEntity(@RequestBody LanguageEntity languageEntity) throws URISyntaxException {
        log.debug("REST request to save LanguageEntity : {}", languageEntity);
        if (languageEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new languageEntity cannot already have an ID")).body(null);
        }
        LanguageEntity result = languageEntityRepository.save(languageEntity);
        return ResponseEntity.created(new URI("/api/language-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    *//**
     * PUT  /language-entities : Updates an existing languageEntity.
     *
     * @param languageEntity the languageEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated languageEntity,
     * or with status 400 (Bad Request) if the languageEntity is not valid,
     * or with status 500 (Internal Server Error) if the languageEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PutMapping("/language-entities")
    @Timed
    public ResponseEntity<LanguageEntity> updateLanguageEntity(@RequestBody LanguageEntity languageEntity) throws URISyntaxException {
        log.debug("REST request to update LanguageEntity : {}", languageEntity);
        if (languageEntity.getId() == null) {
            return createLanguageEntity(languageEntity);
        }
        LanguageEntity result = languageEntityRepository.save(languageEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, languageEntity.getId().toString()))
            .body(result);
    }

    *//**
     * GET  /language-entities : get all the languageEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of languageEntities in body
     *//*
    @GetMapping("/language-entities")
    @Timed
    public List<LanguageEntity> getAllLanguageEntities() {
        log.debug("REST request to get all LanguageEntities");
        return languageEntityRepository.findAll();
    }

    *//**
     * GET  /language-entities/:id : get the "id" languageEntity.
     *
     * @param id the id of the languageEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the languageEntity, or with status 404 (Not Found)
     *//*
    @GetMapping("/language-entities/{id}")
    @Timed
    public ResponseEntity<LanguageEntity> getLanguageEntity(@PathVariable Long id) {
        log.debug("REST request to get LanguageEntity : {}", id);
        LanguageEntity languageEntity = languageEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(languageEntity));
    }

    *//**
     * DELETE  /language-entities/:id : delete the "id" languageEntity.
     *
     * @param id the id of the languageEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     *//*
    @DeleteMapping("/language-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteLanguageEntity(@PathVariable Long id) {
        log.debug("REST request to delete LanguageEntity : {}", id);
        languageEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }*/
}
