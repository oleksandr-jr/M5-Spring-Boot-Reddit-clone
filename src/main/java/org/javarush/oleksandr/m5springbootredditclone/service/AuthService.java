package org.javarush.oleksandr.m5springbootredditclone.service;

import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.javarush.oleksandr.m5springbootredditclone.dto.AuthenticationResponseDTO;
import org.javarush.oleksandr.m5springbootredditclone.dto.LoginRequestDTO;
import org.javarush.oleksandr.m5springbootredditclone.dto.RegisterRequestDTO;
import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public void signup(RegisterRequestDTO registerRequest) {
        User user = User.builder()
                .email(registerRequest.getEmail())
                .name(registerRequest.getName())
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .created(java.time.Instant.now())
                .enabled(true)
                .build();

        userService.save(user);
    }

    public AuthenticationResponseDTO login(LoginRequestDTO loginRequest) {
        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                ));

//        SecurityContextHolder.getContext().setAuthentication(authentication);

        return AuthenticationResponseDTO.builder().build();
    }

}
