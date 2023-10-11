package org.javarush.oleksandr.m5springbootredditclone.service;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.javarush.oleksandr.m5springbootredditclone.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public UserDetails findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserDetails userDetails  =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .roles( "USER" )
                        .build();

        return userDetails;
    }

}
