package org.javarush.oleksandr.m5springbootredditclone.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String text;
    private Long postId;
    private String username;
    private String duration;
}
