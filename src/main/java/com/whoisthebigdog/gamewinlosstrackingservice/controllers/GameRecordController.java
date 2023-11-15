package com.whoisthebigdog.gamewinlosstrackingservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.GameRecordRepository;

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
    private ResponseEntity<Void> createGameRecord(@RequestBody GameRecord newGameRecordRequest, UriComponentsBuilder ucb) {
      // it saves a new GameRecord for us, and returns the saved object with a unique id provided by the database. Amazing!
      GameRecord newGameRecord = new GameRecord(null, newGameRecordRequest.gameId(), newGameRecordRequest.teamId(), newGameRecordRequest.win(), newGameRecordRequest.lose(),newGameRecordRequest.draw(),newGameRecordRequest.gameDateTime());
      GameRecord savedGameRecord = gameRecordRepository.save(newGameRecord);
      URI locationOfNewGameRecord = ucb
                .path("gamerecords/{id}")
                .buildAndExpand(savedGameRecord.gameRecordId())
                .toUri();
      return ResponseEntity.created(locationOfNewGameRecord).build();
    }
}