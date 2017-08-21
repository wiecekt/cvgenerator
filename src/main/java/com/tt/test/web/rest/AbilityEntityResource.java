package com.tt.test.web.rest;

import com.tt.test.domain.AbilityEntity;
import com.tt.test.service.AbilityService;
import com.tt.test.service.dto.AbilityDTO;
import com.tt.test.web.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AbilityEntityResource {

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

}
