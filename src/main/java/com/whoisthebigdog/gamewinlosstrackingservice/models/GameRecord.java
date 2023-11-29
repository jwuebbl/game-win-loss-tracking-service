package com.whoisthebigdog.gamewinlosstrackingservice.models;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

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

// package com.whoisthebigdog.gamewinlosstrackingservice.models;

// import org.springframework.data.annotation.Id;
// import java.time.LocalDateTime;
// import java.util.Optional;

// public record GameRecord(
//     @Id 
//     Long gameRecordId,
//     Long gameId,
//     Long teamId,
//     Boolean win,
//     Boolean lose,
//     Boolean draw,
//     Optional<LocalDateTime> gameDateTime
// ) {
// }