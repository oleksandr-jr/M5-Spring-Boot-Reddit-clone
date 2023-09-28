package org.javarush.oleksandr.m5springbootredditclone.repository;

import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
