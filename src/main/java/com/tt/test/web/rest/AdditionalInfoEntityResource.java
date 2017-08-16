package com.tt.test.web.rest;

import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.service.AdditionalInfoService;
import com.tt.test.service.dto.AdditionalInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing AdditionalInfoEntity.
 */
@RestController
@RequestMapping("/api")
public class AdditionalInfoEntityResource {

    private final Logger log = LoggerFactory.getLogger(AdditionalInfoEntityResource.class);

    private static final String ENTITY_NAME = "additionalInfoEntity";

    private AdditionalInfoService additionalInfoService;

    @Autowired
    public AdditionalInfoEntityResource(AdditionalInfoService additionalInfoService) {
        this.additionalInfoService = additionalInfoService;
    }

    @GetMapping("/additional-info/{id}")
    public AdditionalInfoEntity getAdditionalInfo(@PathVariable("id") Long id) {
        return additionalInfoService.getAdditionalInfoById(id);
    }

    @GetMapping("/additional-info")
    public List<AdditionalInfoEntity> getAllAdditionalInfos() {
        return additionalInfoService.getAllAdditionalInfos();
    }

    @PostMapping("/additional-info")
    public void createAdditionalInfo(@RequestBody AdditionalInfoDTO additionalInfoDTO) {
        additionalInfoService.create(additionalInfoDTO);
    }

    @PutMapping("/additional-info/{id}")
    public void updateAdditionalInfo(@PathVariable("id") Long id, @RequestBody AdditionalInfoDTO additionalInfoDTO) {
        additionalInfoService.updateAdditionalInfo(id, additionalInfoDTO);
    }

    @DeleteMapping("/additional-info/{id}")
    public void deleteAdditionalInfo(@PathVariable("id") Long id) {
        additionalInfoService.deleteAdditionalInfoById(id);
    }

    /**
     * POST  /additional-info-entities : Create a new additionalInfoEntity.
     *
     * @param additionalInfoEntity the additionalInfoEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new additionalInfoEntity, or with status 400 (Bad Request) if the additionalInfoEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
    @PostMapping("/additional-info-entities")
    @Timed
    public ResponseEntity<AdditionalInfoEntity> createAdditionalInfoEntity(@RequestBody AdditionalInfoEntity additionalInfoEntity) throws URISyntaxException {
        log.debug("REST request to save AdditionalInfoEntity : {}", additionalInfoEntity);
        if (additionalInfoEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new additionalInfoEntity cannot already have an ID")).body(null);
        }
        AdditionalInfoEntity result = additionalInfoEntityRepository.save(additionalInfoEntity);
        return ResponseEntity.created(new URI("/api/additional-info-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    *//**
     * PUT  /additional-info-entities : Updates an existing additionalInfoEntity.
     *
     * @param additionalInfoEntity the additionalInfoEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated additionalInfoEntity,
     * or with status 400 (Bad Request) if the additionalInfoEntity is not valid,
     * or with status 500 (Internal Server Error) if the additionalInfoEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *//*
    @PutMapping("/additional-info-entities")
    @Timed
    public ResponseEntity<AdditionalInfoEntity> updateAdditionalInfoEntity(@RequestBody AdditionalInfoEntity additionalInfoEntity) throws URISyntaxException {
        log.debug("REST request to update AdditionalInfoEntity : {}", additionalInfoEntity);
        if (additionalInfoEntity.getId() == null) {
            return createAdditionalInfoEntity(additionalInfoEntity);
        }
        AdditionalInfoEntity result = additionalInfoEntityRepository.save(additionalInfoEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, additionalInfoEntity.getId().toString()))
            .body(result);
    }

    *//**
     * GET  /additional-info-entities : get all the additionalInfoEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of additionalInfoEntities in body
     *//*
    @GetMapping("/additional-info-entities")
    @Timed
    public List<AdditionalInfoEntity> getAllAdditionalInfoEntities() {
        log.debug("REST request to get all AdditionalInfoEntities");
        return additionalInfoEntityRepository.findAll();
    }

    *//**
     * GET  /additional-info-entities/:id : get the "id" additionalInfoEntity.
     *
     * @param id the id of the additionalInfoEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the additionalInfoEntity, or with status 404 (Not Found)
     *//*
    @GetMapping("/additional-info-entities/{id}")
    @Timed
    public ResponseEntity<AdditionalInfoEntity> getAdditionalInfoEntity(@PathVariable Long id) {
        log.debug("REST request to get AdditionalInfoEntity : {}", id);
        AdditionalInfoEntity additionalInfoEntity = additionalInfoEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(additionalInfoEntity));
    }

    *//**
     * DELETE  /additional-info-entities/:id : delete the "id" additionalInfoEntity.
     *
     * @param id the id of the additionalInfoEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     *//*
    @DeleteMapping("/additional-info-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteAdditionalInfoEntity(@PathVariable Long id) {
        log.debug("REST request to delete AdditionalInfoEntity : {}", id);
        additionalInfoEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }*/
}
