package org.javarush.oleksandr.m5springbootredditclone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    @Lob
    private String description;
    // TODO : Implement this:
    private Integer voteCount = 0;

    @ManyToOne(targetEntity = User.class)
    private User user;
    private Instant createdDate;

    @ManyToOne(targetEntity = Subreddit.class)
    @JsonBackReference
    @JoinTable(name = "subreddit_posts",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "subreddit_id"))
    private Subreddit subreddit;
}

