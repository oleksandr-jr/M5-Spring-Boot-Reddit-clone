package org.javarush.oleksandr.m5springbootredditclone.repository;

import org.javarush.oleksandr.m5springbootredditclone.model.Comment;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
    int countByPost(Post post);
}
