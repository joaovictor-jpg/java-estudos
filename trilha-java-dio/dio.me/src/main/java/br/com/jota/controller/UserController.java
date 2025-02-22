package br.com.jota.controller;

import br.com.jota.domain.model.User;
import br.com.jota.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> createdUser(@RequestBody User userToCreated, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/{nameUser}").buildAndExpand(userToCreated.getName()).toUri();
        return ResponseEntity.created(uri).body(userService.create(userToCreated));
    }
}
