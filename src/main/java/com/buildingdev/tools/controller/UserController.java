package com.buildingdev.tools.controller;

import com.buildingdev.tools.dto.UserRequestDTO;
import com.buildingdev.tools.dto.UserResponseDTO;
import com.buildingdev.tools.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        List<UserResponseDTO> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
        UserResponseDTO user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO user){
        UserResponseDTO newUser = userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.id()).toUri();

        return ResponseEntity.created(uri).body(newUser);

    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id,@RequestBody UserRequestDTO user){

        UserResponseDTO updateUser = userService.update(id,user);

        return ResponseEntity.ok().body(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
