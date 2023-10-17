package org.javarush.oleksandr.m5springbootredditclone.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.LoginRequestDTO;
import org.javarush.oleksandr.m5springbootredditclone.dto.RegisterRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody RegisterRequestDTO registerRequest) {
        return ResponseEntity.ok("OK");
    }

    @PostMapping("logout")
    public ResponseEntity<String> logout(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok("OK");
    }
}
