package com.whoisthebigdog.gamewinlosstrackingservice.models;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public record Team(@Id Long teamId,
        String teamName,
        String teamMember_01,
        String teamMember_02,
        String teamMember_03,
        String teamMember_04,
        String teamMember_05,
        String teamMember_06,
        String teamMember_07,
        String teamMember_08,
        String teamMember_09,
        String teamMember_10) {
}