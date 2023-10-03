package org.javarush.oleksandr.m5springbootredditclone.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.PostResponseDTO;
import org.javarush.oleksandr.m5springbootredditclone.mapper.PostMapper;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.javarush.oleksandr.m5springbootredditclone.service.PostService;
import org.javarush.oleksandr.m5springbootredditclone.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/posts/")
public class PostController {
    private final PostService postService;
    private final UserService userService;
    private final PostMapper postMapper;

    @GetMapping
    public List<PostResponseDTO> getAllPosts() {
        return postService.findAll().stream().map(postMapper::mapToDto).toList();
    }
    @GetMapping("{id}")
    public PostResponseDTO getPost(@PathVariable Long id) {
        return postMapper.mapToDto(postService.findById(id));
    }

    @GetMapping("user/{id}")
    public List<Post> getPostByUser(@PathVariable Long id) {
        return postService.findByUser(userService.findById(id));
    }
}
