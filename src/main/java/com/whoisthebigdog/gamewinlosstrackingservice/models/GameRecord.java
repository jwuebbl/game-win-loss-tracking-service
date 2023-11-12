package com.whoisthebigdog.gamewinlosstrackingservice.models;

import javax.persistence.*;
import java.util.Date;

public record GameRecord(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "GameRecordID")
        Long gameRecordID,
        
        @ManyToOne
        @JoinColumn(name = "GameID")
        Game game,
        
        @ManyToOne
        @JoinColumn(name = "TeamID")
        Team team,
        
        @Column(name = "Win")
        boolean win,
        
        @Column(name = "Lose")
        boolean lose,
        
        @Column(name = "Draw")
        boolean draw,
        
        @Column(name = "GameDateTime")
        @Temporal(TemporalType.TIMESTAMP)
        Date gameDateTime
) {}
