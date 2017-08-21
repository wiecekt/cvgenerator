package com.tt.test.web.rest;

import com.tt.test.domain.PermissionEntity;
import com.tt.test.service.PermissionService;
import com.tt.test.service.dto.PermissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PermissionEntityResource {

    private PermissionService permissionService;

    @Autowired
    public PermissionEntityResource(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/permissions/{id}")
    public ResponseEntity<PermissionEntity> getPermission(@PathVariable("id") Long id) {
        PermissionEntity permissionEntity = permissionService.getPermissionById(id);
        return new ResponseEntity<>(permissionEntity, HttpStatus.OK);
    }

    @GetMapping("/permissions")
    public ResponseEntity<List<PermissionEntity>> getAllPermissions() {
        List<PermissionEntity> allPermissions = permissionService.getAllPermissions();
        return new ResponseEntity<>(allPermissions, HttpStatus.OK);
    }

    @PostMapping("/permissions")
    public ResponseEntity<PermissionEntity> createPermission(@RequestBody PermissionDTO permissionDTO) {
        PermissionEntity permissionEntity = permissionService.create(permissionDTO);
        return new ResponseEntity<>(permissionEntity, HttpStatus.OK);
    }

    @PutMapping("/permissions/{id}")
    public ResponseEntity<PermissionEntity> updatePermission(@PathVariable("id") Long id, @RequestBody PermissionDTO permissionDTO) {
        PermissionEntity permissionEntity = permissionService.updatePermission(id, permissionDTO);
        return new ResponseEntity<>(permissionEntity, HttpStatus.OK);
    }

    @DeleteMapping("/permissions/{id}")
    public ResponseEntity<String> deletePermission(@PathVariable("id") Long id) {
        permissionService.deletePermissionById(id);
        return new ResponseEntity<>("Permission with id = " + id + " was successfully removed.", HttpStatus.OK);
    }
}
