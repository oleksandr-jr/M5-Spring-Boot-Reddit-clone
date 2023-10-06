package org.javarush.oleksandr.m5springbootredditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.model.VoteType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDTO {
    private VoteType voteType;
    private Long postId;
}
