package org.javarush.oleksandr.m5springbootredditclone.dto;

import lombok.Data;

@Data
public class PostResponseDTO {
    private Long id;
    private String postName;
    private String url;
    private String description;
    private String userName;
    private String subredditName;
    private Integer voteCount;
    private Integer commentCount;
    private String duration;
    private boolean upVote;
    private boolean downVote;

}
