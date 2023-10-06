package org.javarush.oleksandr.m5springbootredditclone.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.CommentDTO;
import org.javarush.oleksandr.m5springbootredditclone.mapper.CommentMapper;
import org.javarush.oleksandr.m5springbootredditclone.model.Comment;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.javarush.oleksandr.m5springbootredditclone.service.CommentService;
import org.javarush.oleksandr.m5springbootredditclone.service.PostService;
import org.javarush.oleksandr.m5springbootredditclone.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/api/comments/")
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final PostService postService;
    private final UserService userService;

    @GetMapping("by-post/{id}")
    public List<CommentDTO> getCommentsByPost(@PathVariable Long id) {
        return commentService.findByPost(postService.findById(id)).stream()
                .map(commentMapper::mapToDto)
                .toList();
    }

    @GetMapping("user/{id}")
    public List<Comment> getCommentsByUser(@PathVariable Long id) {
        return commentService.findAllByUser(userService.findById(id));
    }

    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
        Post post = postService.findById(commentDTO.getPostId());
        // TODO: Replace user
        User user = userService.findById(1L);
        Comment comment = commentMapper.map(commentDTO, post, user);

        commentService.save(comment);
        return commentDTO;
    }

}
