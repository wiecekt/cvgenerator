package com.tt.test.web.rest;

import com.tt.test.domain.LanguageEntity;
import com.tt.test.service.LanguageService;
import com.tt.test.service.dto.LanguageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LanguageEntityResource {

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
}
