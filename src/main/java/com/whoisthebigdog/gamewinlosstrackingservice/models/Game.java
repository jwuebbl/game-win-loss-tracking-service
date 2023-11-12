package com.whoisthebigdog.gamewinlosstrackingservice.models;

import javax.persistence.*;

public record Game(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "GameID")
        @OneToMany
        Long gameID,
        
        @Column(name = "GameName", length = 50, nullable = false)
        String gameName
) {}
