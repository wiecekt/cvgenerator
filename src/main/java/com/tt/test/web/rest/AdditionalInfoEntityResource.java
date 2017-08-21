package com.tt.test.web.rest;

import com.tt.test.domain.AdditionalInfoEntity;
import com.tt.test.service.AdditionalInfoService;
import com.tt.test.service.dto.AdditionalInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdditionalInfoEntityResource {

    private AdditionalInfoService additionalInfoService;

    @Autowired
    public AdditionalInfoEntityResource(AdditionalInfoService additionalInfoService) {
        this.additionalInfoService = additionalInfoService;
    }

    @GetMapping("/additional-info/{id}")
    public ResponseEntity<AdditionalInfoEntity> getAdditionalInfo(@PathVariable("id") Long id) {
        AdditionalInfoEntity additionalInfoById = additionalInfoService.getAdditionalInfoById(id);
        return new ResponseEntity<>(additionalInfoById, HttpStatus.OK);
    }

    @GetMapping("/additional-info")
    public ResponseEntity<List<AdditionalInfoEntity>> getAllAdditionalInfos() {
        List<AdditionalInfoEntity> allAdditionalInfo = additionalInfoService.getAllAdditionalInfo();
        return new ResponseEntity<>(allAdditionalInfo, HttpStatus.OK);
    }

    @PostMapping("/additional-info")
    public ResponseEntity<AdditionalInfoEntity> createAdditionalInfo(@RequestBody AdditionalInfoDTO additionalInfoDTO) {
        AdditionalInfoEntity additionalInfoEntity = additionalInfoService.create(additionalInfoDTO);
        return new ResponseEntity<>(additionalInfoEntity, HttpStatus.OK);
    }

    @PutMapping("/additional-info/{id}")
    public ResponseEntity<AdditionalInfoEntity> updateAdditionalInfo(@PathVariable("id") Long id, @RequestBody AdditionalInfoDTO additionalInfoDTO) {
        AdditionalInfoEntity additionalInfoEntity = additionalInfoService.updateAdditionalInfo(id, additionalInfoDTO);
        return new ResponseEntity<>(additionalInfoEntity, HttpStatus.OK);
    }

    @DeleteMapping("/additional-info/{id}")
    public ResponseEntity<String> deleteAdditionalInfo(@PathVariable("id") Long id) {
        additionalInfoService.deleteAdditionalInfoById(id);
        return new ResponseEntity<>("AdditionalInfo with id = " + id + " was successfully removed.", HttpStatus.OK);
    }
}
