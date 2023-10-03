package org.javarush.oleksandr.m5springbootredditclone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.javarush.oleksandr.m5springbootredditclone.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
    @Transactional(readOnly = true)
    public Post save(Post post) {
        return postRepository.save(post);
    }
    @Transactional(readOnly = true)
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public List<Post> findByUser(User user) {
        return postRepository.findByUser(user);
    }

}
