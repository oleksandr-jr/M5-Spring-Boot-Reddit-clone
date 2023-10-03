package org.javarush.oleksandr.m5springbootredditclone.service;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.SubredditDTO;
import org.javarush.oleksandr.m5springbootredditclone.mapper.SubredditMapper;
import org.javarush.oleksandr.m5springbootredditclone.model.Subreddit;
import org.javarush.oleksandr.m5springbootredditclone.repository.SubredditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubredditService {
    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    public List<Subreddit> findAll() {
        return subredditRepository.findAll();
    }
    public Subreddit findById(Long id) {
        return subredditRepository.findById(id).orElse(null);
    }
    public Subreddit findByName(String subredditName) {
        return subredditRepository.findByName(subredditName);
    }
    public Subreddit save(Subreddit subreddit) {
        return subredditRepository.save(subreddit);
    }
    public Subreddit save(SubredditDTO subredditDTO) {
        return subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDTO));
    }
    public void deleteById(Long id) {
        subredditRepository.deleteById(id);
    }
    public void delete(Subreddit subreddit) {
        subredditRepository.delete(subreddit);
    }
}
