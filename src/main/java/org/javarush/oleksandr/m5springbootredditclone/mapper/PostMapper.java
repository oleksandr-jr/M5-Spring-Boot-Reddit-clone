package org.javarush.oleksandr.m5springbootredditclone.mapper;

import org.javarush.oleksandr.m5springbootredditclone.dto.PostRequestDTO;
import org.javarush.oleksandr.m5springbootredditclone.dto.PostResponseDTO;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.javarush.oleksandr.m5springbootredditclone.model.Subreddit;
import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.javarush.oleksandr.m5springbootredditclone.service.CommentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {CommentService.class})
public abstract class PostMapper {
    @Autowired
    public CommentService commentService;

    @Mapping(target = "postName", source = "name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "commentCount", expression = "java(commentService.countByPost(post))")
    public abstract PostResponseDTO mapToDto(Post post);

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "subreddit", source = "subreddit")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "id", source = "postRequestDTO.postId")
    @Mapping(target = "name", source = "postRequestDTO.postName")
    @Mapping(target = "description", source = "postRequestDTO.description")
    public abstract Post mapToPost(PostRequestDTO postRequestDTO, Subreddit subreddit, User user);

}
