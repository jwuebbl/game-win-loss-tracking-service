package com.whoisthebigdog.gamewinlosstrackingservice.controllers;

import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.GameRecordRepository;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gamerecords")
public class GameRecordController {

    private final GameRecordRepository gameRecordRepository;

    @Autowired
    public GameRecordController(GameRecordRepository gameRecordRepository) {
        this.gameRecordRepository = gameRecordRepository;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<GameRecord> getGameRecordById(@PathVariable Long requestedId) {
        System.out.println("jeffrey " + requestedId);
        Optional<GameRecord> gameRecordOptional = gameRecordRepository.findById(requestedId);
        return gameRecordOptional
                .map(gameRecord -> ResponseEntity.ok().body(gameRecord)) // If present, return 200 with the GameRecord
                .orElse(ResponseEntity.notFound().build()); // If absent, return 404 (Not Found)
    }
}
