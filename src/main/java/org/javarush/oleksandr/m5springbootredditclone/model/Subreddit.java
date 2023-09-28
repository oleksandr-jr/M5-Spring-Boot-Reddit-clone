package org.javarush.oleksandr.m5springbootredditclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subreddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Instant createdDate;

    @OneToMany(targetEntity = Post.class)
    private List<Post> posts;

    @ManyToOne(targetEntity = User.class)
    private User user;
}
