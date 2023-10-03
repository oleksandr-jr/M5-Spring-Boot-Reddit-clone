package org.javarush.oleksandr.m5springbootredditclone.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.SubredditDTO;
import org.javarush.oleksandr.m5springbootredditclone.mapper.SubredditMapper;
import org.javarush.oleksandr.m5springbootredditclone.model.Subreddit;
import org.javarush.oleksandr.m5springbootredditclone.service.SubredditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/subreddit")
@RequiredArgsConstructor
public class SubredditController {
    private final SubredditService subredditService;
    private final SubredditMapper subredditMapper;

    @GetMapping
    public List<Subreddit> getAllSubreddits() {
        return subredditService.findAll();
    }
    @PostMapping
    public ResponseEntity<SubredditDTO> createSubreddit(@RequestBody SubredditDTO subredditDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subredditMapper.mapSubredditToDto(subredditService.save(subredditDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubredditDTO> getSubreddit(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subredditMapper.mapSubredditToDto(subredditService.findById(id)));
    }


}
