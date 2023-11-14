package com.whoisthebigdog.gamewinlosstrackingservice.models;

import org.springframework.data.annotation.Id;

public record Game(@Id Long gameId, String gameName) {
}