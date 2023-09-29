package org.javarush.oleksandr.m5springbootredditclone.model;

public enum VoteType {
    UPVOTE(1), DOWNVOTE(-1);

    VoteType(int direction) {
    }
}
