package org.javarush.oleksandr.m5springbootredditclone.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javarush.oleksandr.m5springbootredditclone.dto.PostRequestDTO;
import org.javarush.oleksandr.m5springbootredditclone.mapper.PostMapper;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.javarush.oleksandr.m5springbootredditclone.model.Subreddit;
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
    private final SubredditService subredditService;
    private final UserService userService;
    private final PostMapper postMapper;

    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
    @Transactional(readOnly = true)
    public void save(Post post) {
        postRepository.save(post);
    }

    @Transactional
    public void save(PostRequestDTO postRequestDTO) {
        Subreddit subreddit = subredditService.findByName(postRequestDTO.getSubredditName());
        // TODO: Replace user
        User user = userService.findById(1L);
        Post post = postMapper.mapToPost(postRequestDTO, subreddit, user);
        postRepository.save(post);
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

    @Transactional(readOnly = true)
    public List<Post> findBySubredditId(Long id) {
        return postRepository.findBySubredditId(id);
    }
}
