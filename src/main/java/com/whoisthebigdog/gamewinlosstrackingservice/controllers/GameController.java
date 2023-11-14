package com.whoisthebigdog.gamewinlosstrackingservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoisthebigdog.gamewinlosstrackingservice.models.Game;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.GameRepository;

import java.util.*;

@RestController
@RequestMapping("/games")
public class GameController {
    
    private GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<Optional<Game>> findById(@PathVariable Long requestedId) {
        Optional<Game> game = gameRepository.findById(requestedId);
        if (game.isPresent()) {
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}