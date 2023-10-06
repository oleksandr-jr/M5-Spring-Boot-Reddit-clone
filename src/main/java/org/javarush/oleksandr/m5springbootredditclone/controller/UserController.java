package org.javarush.oleksandr.m5springbootredditclone.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.javarush.oleksandr.m5springbootredditclone.repository.UserRepository;
import org.javarush.oleksandr.m5springbootredditclone.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }
}
