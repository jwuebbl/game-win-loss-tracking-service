package com.whoisthebigdog.gamewinlosstrackingservice.models;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

public record Game(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GameID")
    Long gameID,

    @Column(name = "GameName")
    String gameName
) {}
