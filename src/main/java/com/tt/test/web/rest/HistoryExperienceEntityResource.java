package com.tt.test.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.tt.test.domain.HistoryExperienceEntity;

import com.tt.test.repository.HistoryExperienceEntityRepository;
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
 * REST controller for managing HistoryExperienceEntity.
 */
@RestController
@RequestMapping("/api")
public class HistoryExperienceEntityResource {

    private final Logger log = LoggerFactory.getLogger(HistoryExperienceEntityResource.class);

    private static final String ENTITY_NAME = "historyExperienceEntity";

    private final HistoryExperienceEntityRepository historyExperienceEntityRepository;

    public HistoryExperienceEntityResource(HistoryExperienceEntityRepository historyExperienceEntityRepository) {
        this.historyExperienceEntityRepository = historyExperienceEntityRepository;
    }

    /**
     * POST  /history-experience-entities : Create a new historyExperienceEntity.
     *
     * @param historyExperienceEntity the historyExperienceEntity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new historyExperienceEntity, or with status 400 (Bad Request) if the historyExperienceEntity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/history-experience-entities")
    @Timed
    public ResponseEntity<HistoryExperienceEntity> createHistoryExperienceEntity(@RequestBody HistoryExperienceEntity historyExperienceEntity) throws URISyntaxException {
        log.debug("REST request to save HistoryExperienceEntity : {}", historyExperienceEntity);
        if (historyExperienceEntity.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new historyExperienceEntity cannot already have an ID")).body(null);
        }
        HistoryExperienceEntity result = historyExperienceEntityRepository.save(historyExperienceEntity);
        return ResponseEntity.created(new URI("/api/history-experience-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /history-experience-entities : Updates an existing historyExperienceEntity.
     *
     * @param historyExperienceEntity the historyExperienceEntity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated historyExperienceEntity,
     * or with status 400 (Bad Request) if the historyExperienceEntity is not valid,
     * or with status 500 (Internal Server Error) if the historyExperienceEntity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/history-experience-entities")
    @Timed
    public ResponseEntity<HistoryExperienceEntity> updateHistoryExperienceEntity(@RequestBody HistoryExperienceEntity historyExperienceEntity) throws URISyntaxException {
        log.debug("REST request to update HistoryExperienceEntity : {}", historyExperienceEntity);
        if (historyExperienceEntity.getId() == null) {
            return createHistoryExperienceEntity(historyExperienceEntity);
        }
        HistoryExperienceEntity result = historyExperienceEntityRepository.save(historyExperienceEntity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, historyExperienceEntity.getId().toString()))
            .body(result);
    }

    /**
     * GET  /history-experience-entities : get all the historyExperienceEntities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of historyExperienceEntities in body
     */
    @GetMapping("/history-experience-entities")
    @Timed
    public List<HistoryExperienceEntity> getAllHistoryExperienceEntities() {
        log.debug("REST request to get all HistoryExperienceEntities");
        return historyExperienceEntityRepository.findAll();
    }

    /**
     * GET  /history-experience-entities/:id : get the "id" historyExperienceEntity.
     *
     * @param id the id of the historyExperienceEntity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the historyExperienceEntity, or with status 404 (Not Found)
     */
    @GetMapping("/history-experience-entities/{id}")
    @Timed
    public ResponseEntity<HistoryExperienceEntity> getHistoryExperienceEntity(@PathVariable Long id) {
        log.debug("REST request to get HistoryExperienceEntity : {}", id);
        HistoryExperienceEntity historyExperienceEntity = historyExperienceEntityRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(historyExperienceEntity));
    }

    /**
     * DELETE  /history-experience-entities/:id : delete the "id" historyExperienceEntity.
     *
     * @param id the id of the historyExperienceEntity to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/history-experience-entities/{id}")
    @Timed
    public ResponseEntity<Void> deleteHistoryExperienceEntity(@PathVariable Long id) {
        log.debug("REST request to delete HistoryExperienceEntity : {}", id);
        historyExperienceEntityRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
