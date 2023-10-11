package org.javarush.oleksandr.m5springbootredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponseDTO {
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;
}
