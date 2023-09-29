package org.javarush.oleksandr.m5springbootredditclone.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.model.Comment;
import org.javarush.oleksandr.m5springbootredditclone.service.CommentService;
import org.javarush.oleksandr.m5springbootredditclone.service.PostService;
import org.javarush.oleksandr.m5springbootredditclone.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;

    @GetMapping("/post/{id}")
    public List<Comment> getCommentsByPost(@PathVariable Long id) {
        return commentService.findByPost(postService.findById(id));
    }

    @GetMapping("/user/{id}")
    public List<Comment> getCommentsByUser(@PathVariable Long id) {
        return commentService.findAllByUser(userService.findById(id));
    }

}
