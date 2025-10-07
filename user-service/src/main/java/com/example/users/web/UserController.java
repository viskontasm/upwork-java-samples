package com.example.users.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.example.users.repo.UserRepository;
import com.example.users.domain.User;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository repo;

    public UserController(UserRepository repository) {
        this.repo = repository;
    }

    @GetMapping
    public List<User> all() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User u) {
        return ResponseEntity.status(201).body(repo.save(u));
    }
}