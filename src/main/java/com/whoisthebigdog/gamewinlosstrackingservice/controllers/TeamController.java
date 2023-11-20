package com.whoisthebigdog.gamewinlosstrackingservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;


import com.whoisthebigdog.gamewinlosstrackingservice.models.Team;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.TeamRepository;

import java.util.*;

@RestController
@RequestMapping("/teams")
public class TeamController {
    
    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<Optional<Team>> findById(@PathVariable Long requestedId) {
        Optional<Team> team = teamRepository.findById(requestedId);
        if (team.isPresent()) {
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createGame(@RequestBody Team newTeamRequest, UriComponentsBuilder ucb) {
      // it saves a new Game for us, and returns the saved object with a unique id provided by the database. Amazing!
      Team savedTeam = teamRepository.save(newTeamRequest);
      URI locationOfNewGame = ucb
                .path("games/" + savedTeam.teamId())
                .buildAndExpand(savedTeam.teamId())
                .toUri();
      return ResponseEntity.created(locationOfNewGame).build();
    }
}