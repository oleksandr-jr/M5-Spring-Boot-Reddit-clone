package org.javarush.oleksandr.m5springbootredditclone.service;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.VoteDTO;
import org.javarush.oleksandr.m5springbootredditclone.model.Post;
import org.javarush.oleksandr.m5springbootredditclone.model.Vote;
import org.javarush.oleksandr.m5springbootredditclone.repository.VoteRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final PostService postService;
    private final UserService userService;

    public void vote(VoteDTO voteDTO) {
        // TODO: Check if user has already voted for this post
        Post post = postService.findById(voteDTO.getPostId());
        post.setVoteCount(post.getVoteCount() + voteDTO.getVoteType().getDirection());

        postService.save(post);
        voteRepository.save(mapToVote(voteDTO, post));
    }

    private Vote mapToVote(VoteDTO voteDTO, Post post) {
        // TODO: Replace user
        return Vote.builder()
                .voteType(voteDTO.getVoteType())
                .post(post)
                .user(userService.findById(1L))
                .build();
    }
}
