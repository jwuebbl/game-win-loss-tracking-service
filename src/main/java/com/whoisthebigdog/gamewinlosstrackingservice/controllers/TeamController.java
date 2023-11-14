package com.whoisthebigdog.gamewinlosstrackingservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}