package org.javarush.oleksandr.m5springbootredditclone.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.LoginRequestDTO;
import org.javarush.oleksandr.m5springbootredditclone.dto.RegisterRequestDTO;
import org.javarush.oleksandr.m5springbootredditclone.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {
    private final AuthService authService;

    @PostMapping("signup")
    public ResponseEntity<String> test(@RequestBody RegisterRequestDTO registerRequest) {
//        authService.signup(registerRequest);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("login")
    public ResponseEntity<String> test2(@RequestBody LoginRequestDTO loginRequestDTO) {
//        authService.login(loginRequestDTO);
        return ResponseEntity.ok("OK");
    }
}
