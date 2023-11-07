package com.whoisthebigdog.gamewinlosstrackingservice.models;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

public record Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TeamID")
    Long teamID,

    @Column(name = "TeamName")
    String teamName,

    @Column(name = "TeamMember01")
    String teamMember01,

    @Column(name = "TeamMember02")
    String teamMember02,

    @Column(name = "TeamMember03")
    String teamMember03,

    @Column(name = "TeamMember04")
    String teamMember04,

    @Column(name = "TeamMember05")
    String teamMember05,

    @Column(name = "TeamMember06")
    String teamMember06,

    @Column(name = "TeamMember07")
    String teamMember07,

    @Column(name = "TeamMember08")
    String teamMember08,

    @Column(name = "TeamMember09")
    String teamMember09,

    @Column(name = "TeamMember10")
    String teamMember10
) {}
