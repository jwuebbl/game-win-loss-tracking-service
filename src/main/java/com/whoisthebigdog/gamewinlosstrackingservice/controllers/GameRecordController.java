package com.whoisthebigdog.gamewinlosstrackingservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.whoisthebigdog.gamewinlosstrackingservice.models.Game;
import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.GameRecordRepository;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.GameRepository;

import java.net.URI;
import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/gamerecords")
public class GameRecordController {
    
    private GameRecordRepository gameRecordRepository;

    public GameRecordController(GameRecordRepository gameRecordRepository) {
        this.gameRecordRepository = gameRecordRepository;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<Optional<GameRecord>> findById(@PathVariable Long requestedId) {
        Optional<GameRecord> gameRecord = gameRecordRepository.findById(requestedId);
        if (gameRecord.isPresent()) {
            return ResponseEntity.ok(gameRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createGame(@RequestBody GameRecord newGameRecordRequest, UriComponentsBuilder ucb) {
      // it saves a new Game for us, and returns the saved object with a unique id provided by the database. Amazing!
      GameRecord savedGameRecord = gameRecordRepository.save(newGameRecordRequest);
      URI locationOfNewGameRecord = ucb
                .path("gamerecords/{id}")
                .buildAndExpand(savedGameRecord.gameId())
                .toUri();
      return ResponseEntity.created(locationOfNewGameRecord).build();
    }

}