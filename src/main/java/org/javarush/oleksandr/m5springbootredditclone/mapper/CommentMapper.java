package org.javarush.oleksandr.m5springbootredditclone.mapper;

import org.javarush.oleksandr.m5springbootredditclone.dto.CommentDTO;
import org.javarush.oleksandr.m5springbootredditclone.model.Comment;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "postId", source = "post", qualifiedByName = "getPostId")
    @Mapping(target = "username", expression = "java(comment.getUser().getUsername())")
    CommentDTO mapToDto(Comment comment);

    @Named("getPostId")
    static Long bToId(Post post) {
        return post.getId();
    }
}
