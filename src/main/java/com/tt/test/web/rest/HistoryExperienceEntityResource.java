package com.tt.test.web.rest;

import com.tt.test.domain.HistoryExperienceEntity;
import com.tt.test.service.HistoryExperienceService;
import com.tt.test.service.dto.HistoryExperienceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryExperienceEntityResource {

    private HistoryExperienceService historyExperienceService;

    @Autowired
    public HistoryExperienceEntityResource(HistoryExperienceService historyExperienceService) {
        this.historyExperienceService = historyExperienceService;
    }

    @GetMapping("/history-experiences/{id}")
    public ResponseEntity<HistoryExperienceEntity> getHistoryExperience(@PathVariable("id") Long id) {
        HistoryExperienceEntity historyExperienceEntity = historyExperienceService.getHistoryExperienceById(id);
        return new ResponseEntity<>(historyExperienceEntity, HttpStatus.OK);
    }

    @GetMapping("/history-experiences")
    public ResponseEntity<List<HistoryExperienceEntity>> getAllHistoryExperiences() {
        List<HistoryExperienceEntity> allHistoryExperiences = historyExperienceService.getAllHistoryExperiences();
        return new ResponseEntity<>(allHistoryExperiences, HttpStatus.OK);
    }

    @PostMapping("/history-experiences")
    public ResponseEntity<HistoryExperienceEntity> createHistoryExperience(@RequestBody HistoryExperienceDTO historyExperienceDTO) {
        HistoryExperienceEntity historyExperienceEntity = historyExperienceService.create(historyExperienceDTO);
        return new ResponseEntity<>(historyExperienceEntity, HttpStatus.OK);
    }

    @PutMapping("/history-experiences/{id}")
    public ResponseEntity<HistoryExperienceEntity> updateHistoryExperience(@PathVariable("id") Long id, @RequestBody HistoryExperienceDTO historyExperienceDTO) {
        HistoryExperienceEntity historyExperienceEntity = historyExperienceService.updateHistoryExperience(id, historyExperienceDTO);
        return new ResponseEntity<>(historyExperienceEntity, HttpStatus.OK);
    }

    @DeleteMapping("/history-experiences/{id}")
    public ResponseEntity<String> deleteHistoryExperience(@PathVariable("id") Long id) {
        historyExperienceService.deleteHistoryExperienceById(id);
        return new ResponseEntity<>("HistoryExperience with id = " + id + " was successfully removed.", HttpStatus.OK);
    }
}
