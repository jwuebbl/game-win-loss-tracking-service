package com.whoisthebigdog.gamewinlosstrackingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

import com.whoisthebigdog.gamewinlosstrackingservice.models.Game;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.GameRepository;

import java.util.*;

@RestController
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    
    @GetMapping()
    public ResponseEntity<List<Game>> findAllGames() {
        List<Game> games = (List<Game>) gameRepository.findAll();
        if (!games.isEmpty()) {
            return ResponseEntity.ok(games);
        } else {
            return ResponseEntity.noContent().build();
        }
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

    @PostMapping
    private ResponseEntity<Void> createGame(@RequestBody Game newGameRequest, UriComponentsBuilder ucb) {
      // it saves a new Game for us, and returns the saved object with a unique id provided by the database. Amazing!
      Game savedGame = gameRepository.save(newGameRequest);
      URI locationOfNewGame = ucb
                .path("games/" + savedGame.gameId())
                .buildAndExpand(savedGame.gameId())
                .toUri();
      return ResponseEntity.created(locationOfNewGame).build();
    }
}