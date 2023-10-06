package org.javarush.oleksandr.m5springbootredditclone.mapper;

import org.javarush.oleksandr.m5springbootredditclone.dto.CommentDTO;
import org.javarush.oleksandr.m5springbootredditclone.model.Comment;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.javarush.oleksandr.m5springbootredditclone.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "postId", source = "post", qualifiedByName = "getPostId")
    @Mapping(target = "username", expression = "java(comment.getUser().getUsername())")
    CommentDTO mapToDto(Comment comment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentDTO.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    Comment map(CommentDTO commentDTO, Post post, User user);

    @Named("getPostId")
    static Long bToId(Post post) {
        return post.getId();
    }
}
