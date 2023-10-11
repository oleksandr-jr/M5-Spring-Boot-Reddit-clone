package org.javarush.oleksandr.m5springbootredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    private String email;
    private String name;
    private String username;
    private String password;
}
