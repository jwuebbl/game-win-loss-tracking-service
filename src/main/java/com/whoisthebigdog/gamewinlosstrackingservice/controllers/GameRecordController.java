package com.whoisthebigdog.gamewinlosstrackingservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.GameRecordRepository;

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
}