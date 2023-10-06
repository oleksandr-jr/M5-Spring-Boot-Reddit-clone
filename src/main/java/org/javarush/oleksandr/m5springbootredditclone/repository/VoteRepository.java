package org.javarush.oleksandr.m5springbootredditclone.repository;

import org.javarush.oleksandr.m5springbootredditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
