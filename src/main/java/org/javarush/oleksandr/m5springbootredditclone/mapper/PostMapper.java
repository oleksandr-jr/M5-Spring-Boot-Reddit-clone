package org.javarush.oleksandr.m5springbootredditclone.mapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.PostResponseDTO;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
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

}
