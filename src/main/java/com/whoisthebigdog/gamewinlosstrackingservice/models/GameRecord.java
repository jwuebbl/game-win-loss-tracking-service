package com.whoisthebigdog.gamewinlosstrackingservice.models;

import javax.persistence.*;
import java.util.Date;

public record GameRecord(
        @Id
        @org.springframework.data.annotation.Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "GameRecordID")
        Long gameRecordID,
        
        @ManyToOne
        @JoinColumn(name = "GameID", referencedColumnName = "GameID")
        Game game,
        
        @ManyToOne
        @JoinColumn(name = "TeamID", referencedColumnName = "TeamID") // referencing the primary key of Team
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
