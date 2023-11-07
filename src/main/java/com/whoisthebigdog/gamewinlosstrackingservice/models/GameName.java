package com.whoisthebigdog.gamewinlosstrackingservice.models;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

public record GameName(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GameNameID")
    Long gameNameID,

    @Column(name = "GameName")
    String gameName
) {}