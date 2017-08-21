package com.tt.test.web.rest;

import com.tt.test.domain.UserEntity;
import com.tt.test.service.UserEntityService;
import com.tt.test.service.dto.UserEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserEntityResource {

   private UserEntityService userEntityService;

   @Autowired
    public UserEntityResource(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable("id") Long id) {
        UserEntity userEntity = userEntityService.getUserById(id);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> allUsers = userEntityService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntityDTO userEntityDTO) {
        UserEntity userEntity = userEntityService.create(userEntityDTO);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable("id") Long id, @RequestBody UserEntityDTO userEntityDTO) {
        UserEntity userEntity = userEntityService.updateUser(id, userEntityDTO);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userEntityService.deleteUserById(id);
        return new ResponseEntity<>("User with id = " + id + " was successfully removed.", HttpStatus.OK);
    }
}
