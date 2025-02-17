package br.com.jota.aula_spring_data_jpa.controller;

import br.com.jota.aula_spring_data_jpa.model.User;
import br.com.jota.aula_spring_data_jpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService servece) {
        this.service = servece;
    }

    @PostMapping()
    public ResponseEntity<Void> createdUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        service.createdUser(user);

        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping()
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok().body(service.listUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> userById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.userById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user, UriComponentsBuilder uriComponentsBuilder) throws Exception {
        service.updateUser(id, user);
        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
