package com.whoisthebigdog.gamewinlosstrackingservice.models;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public record GameRecord(
    @Id 
    Long gameRecordId,
    Long gameId,
    Long teamId,
    Boolean win,
    Boolean lose,
    Boolean draw,
    LocalDateTime gameDateTime
) {
}
