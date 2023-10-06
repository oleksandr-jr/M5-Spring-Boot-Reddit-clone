package org.javarush.oleksandr.m5springbootredditclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long voteId;
    private VoteType voteType;

    @ManyToOne(targetEntity = Post.class)
    private Post post;

    @ManyToOne(targetEntity = User.class)
    private User user;
}
