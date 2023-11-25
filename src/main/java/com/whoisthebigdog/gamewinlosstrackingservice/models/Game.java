package com.whoisthebigdog.gamewinlosstrackingservice.models;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public record Game(@Id Long gameId, String gameName) {
}