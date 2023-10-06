package org.javarush.oleksandr.m5springbootredditclone.model;

public enum VoteType {
    UPVOTE(1),
    DOWNVOTE(-1),
    ;
    private final int direction;

    VoteType(int direction) {
        this.direction = direction;
    }

    public Integer getDirection() {
        return direction;
    }
}
