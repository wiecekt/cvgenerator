package com.tt.test.web.rest;

import com.tt.test.domain.DictionaryEntity;
import com.tt.test.service.DictionaryService;
import com.tt.test.service.dto.DictionaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DictionaryEntityResource {

    private DictionaryService dictionaryService;

    @Autowired
    public DictionaryEntityResource(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/dictionaries/{section}")
    public ResponseEntity<List<DictionaryEntity>> getDictionaryBySection(@PathVariable("section") String section) {
        List<DictionaryEntity> dictionariesBySection = dictionaryService.getDictionariesBySection(section.toUpperCase());
        return new ResponseEntity<>(dictionariesBySection, HttpStatus.OK);
    }

    @GetMapping("/dictionaries/{id}")
    public ResponseEntity<DictionaryEntity> getDictionary(@PathVariable("id") Long id) {
        DictionaryEntity dictionaryById = dictionaryService.getDictionaryById(id);
        return new ResponseEntity<>(dictionaryById, HttpStatus.OK);
    }

    @GetMapping("/dictionaries")
    public ResponseEntity<List<DictionaryEntity>> getAllDictionaries() {
        List<DictionaryEntity> allDictionaries = dictionaryService.getAllDictionaries();
        return new ResponseEntity<>(allDictionaries, HttpStatus.OK);
    }

    @PostMapping("/dictionaries")
    public ResponseEntity<DictionaryEntity> createDictionary(@RequestBody DictionaryDTO dictionaryDTO) {
        DictionaryEntity dictionaryEntity = dictionaryService.create(dictionaryDTO);
        return new ResponseEntity<>(dictionaryEntity, HttpStatus.OK);
    }

    @PutMapping("/dictionaries/{id}")
    public ResponseEntity<DictionaryEntity> updateDictionary(@PathVariable("id") Long id, @RequestBody DictionaryDTO dictionaryDTO) {
        DictionaryEntity dictionaryEntity = dictionaryService.updateDictionary(id, dictionaryDTO);
        return new ResponseEntity<>(dictionaryEntity, HttpStatus.OK);
    }

    @DeleteMapping("/dictionaries/{id}")
    public ResponseEntity<String> deleteDictionary(@PathVariable("id") Long id) {
        dictionaryService.deleteDictionaryById(id);
        return new ResponseEntity<>("Dictionary with id = " + id + " was successfully removed.", HttpStatus.OK);
    }
}
