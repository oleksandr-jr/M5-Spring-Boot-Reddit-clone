package org.javarush.oleksandr.m5springbootredditclone.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.m5springbootredditclone.dto.VoteDTO;
import org.javarush.oleksandr.m5springbootredditclone.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/votes/")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<Void> vote(@RequestBody VoteDTO voteDto) {
        voteService.vote(voteDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
