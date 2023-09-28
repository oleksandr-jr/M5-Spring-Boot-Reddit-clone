package org.javarush.oleksandr.m5springbootredditclone.repository;

import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
