package org.javarush.oleksandr.m5springbootredditclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Instant createdDate;
    @ManyToOne(targetEntity = Post.class)
    private Post post;
    @ManyToOne(targetEntity = User.class)
    private User user;
}
