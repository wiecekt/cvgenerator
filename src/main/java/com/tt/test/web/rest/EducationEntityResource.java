package com.tt.test.web.rest;

import com.tt.test.domain.EducationEntity;
import com.tt.test.service.EducationService;
import com.tt.test.service.dto.EducationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EducationEntityResource {

    private EducationService educationService;

    @Autowired
    public EducationEntityResource(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/education/{id}")
    public ResponseEntity<EducationEntity> getEducation(@PathVariable("id") Long id) {
        EducationEntity educationEntity = educationService.getEducationById(id);
        return new ResponseEntity<>(educationEntity, HttpStatus.OK);
    }

    @GetMapping("/education")
    public ResponseEntity<List<EducationEntity>> getAllEducation() {
        List<EducationEntity> allEducation = educationService.getAllEducation();
        return new ResponseEntity<>(allEducation, HttpStatus.OK);
    }

    @PostMapping("/education")
    public ResponseEntity<EducationEntity> createEducation(@RequestBody EducationDTO educationDTO) {
        EducationEntity educationEntity = educationService.create(educationDTO);
        return new ResponseEntity<>(educationEntity, HttpStatus.OK);
    }

    @PutMapping("/education/{id}")
    public ResponseEntity<EducationEntity> updateEducation(@PathVariable("id") Long id, @RequestBody EducationDTO educationDTO) {
        EducationEntity educationEntity = educationService.updateEducation(id, educationDTO);
        return new ResponseEntity<>(educationEntity, HttpStatus.OK);
    }

    @DeleteMapping("/education/{id}")
    public ResponseEntity<String> deleteEducation(@PathVariable("id") Long id) {
        educationService.deleteEducationById(id);
        return new ResponseEntity<>("Education with id = " + id + " was successfully removed.", HttpStatus.OK);
    }
}
