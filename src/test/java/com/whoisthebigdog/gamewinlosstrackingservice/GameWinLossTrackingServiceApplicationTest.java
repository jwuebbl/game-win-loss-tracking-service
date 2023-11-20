package com.whoisthebigdog.gamewinlosstrackingservice;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.whoisthebigdog.gamewinlosstrackingservice.models.Game;
import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;
import com.whoisthebigdog.gamewinlosstrackingservice.models.Team;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameWinLossTrackingServiceApplicationTest {
    
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnAGameRecordWithAKnownId() {
        ResponseEntity<String> response = restTemplate
        .getForEntity("/gamerecords/5", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number gameRecordId = documentContext.read("$.gameRecordId");
        assertThat(gameRecordId).isEqualTo(5);

        Number gameId = documentContext.read("$.gameId");
        assertThat(gameId).isEqualTo(5);
        
        Number teamId = documentContext.read("$.teamId");
        assertThat(teamId).isEqualTo(5);

        Boolean win = documentContext.read("$.win");
        assertThat(win).isEqualTo(true);

        Boolean lose = documentContext.read("$.lose");
        assertThat(lose).isEqualTo(false);

        Boolean draw = documentContext.read("$.draw");
        assertThat(draw).isEqualTo(false);

        String gameDateTime = documentContext.read("$.gameDateTime");
        assertThat(gameDateTime).isEqualTo("2023-12-07T10:56:04");
    }

    @Test
    void shouldReturnAGameWithAKnownId() {
        ResponseEntity<String> response = restTemplate
        .getForEntity("/games/5", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.gameId");
        assertThat(id).isEqualTo(5);

        String gameName = documentContext.read("$.gameName");
        assertThat(gameName).isEqualTo("Golf");
    }

    @Test
    void shouldNotReturnAGameWithAnUnknownId() {
        ResponseEntity<String> response = restTemplate
        .getForEntity("/games/1000", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isBlank();
    }

    @Test
    void shouldReturnATeamWithAKnownId() {
        ResponseEntity<String> response = restTemplate
        .getForEntity("/teams/5", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.teamId");
        assertThat(id).isEqualTo(5);

        String teamName = documentContext.read("$.teamName");
        assertThat(teamName).isEqualTo("Uh Oh Boyz");

        String teamMember01 = documentContext.read("$.teamMember_01");
        assertThat(teamMember01).isEqualTo("Alex");

        String teamMember02 = documentContext.read("$.teamMember_02");
        assertThat(teamMember02).isEqualTo("Drew");

        String teamMember03 = documentContext.read("$.teamMember_03");
        assertThat(teamMember03).isEqualTo("Jeff");


    }

    @Test
    void shouldNotReturnATeamWithAnUnknownId() {
        ResponseEntity<String> response = restTemplate
        .getForEntity("/teams/1000", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isBlank();
    }

    @Test
    void shouldCreateANewGame() {
        Game newGame = new Game(null, "unitTestGame");
        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/games", newGame, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        URI locationOfNewGame = createResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewGame, String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
        Number gameId = documentContext.read("$.gameId");
        assertThat(gameId).isNotNull();
        String gameName = documentContext.read("$.gameName");
        assertThat(newGame.gameId()).isEqualTo(gameName);
    }

    @Test
    void shouldCreateANewTeam() {
        Team newTeam = new Team(null, "unitTestTeam", "teamMember01", "teamMember02", "teamMember03", null, null, null, null, null, null, null);
        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/teams", newTeam, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        URI locationOfNewTeam = createResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewTeam, String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
        System.out.println(documentContext.jsonString());
        Number teamId = documentContext.read("$.teamId");
        assertThat(teamId).isNotNull();
        String teamName = documentContext.read("$.teamName");
        assertThat(newTeam.teamName()).isEqualTo(teamName);
        String teamMember01 = documentContext.read("$.teamMember_01");
        assertThat(newTeam.teamMember_01()).isEqualTo(teamMember01);
        String teamMember02 = documentContext.read("$.teamMember_02");
        assertThat(newTeam.teamMember_02()).isEqualTo(teamMember02);
        String teamMember03 = documentContext.read("$.teamMember_03");
        assertThat(newTeam.teamMember_03()).isEqualTo(teamMember03);
    }

    @Test
    void shouldCreateANewGameRecord() {
        LocalDateTime now = LocalDateTime.now();
        GameRecord newGameRecord = new GameRecord(null, 5L, 5L, true, false, false, now);
        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/gamerecords", newGameRecord, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        URI locationOfNewGameRecord = createResponse.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewGameRecord, String.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
        Number gameRecordId = documentContext.read("$.gameRecordId");
        assertThat(gameRecordId).isNotNull();
        Number gameId = documentContext.read("$.gameId");
        assertThat(gameId.toString()).isEqualTo(newGameRecord.gameId().toString());
        Number teamId = documentContext.read("$.teamId");
        assertThat(teamId.toString()).isEqualTo(newGameRecord.teamId().toString());
        Boolean win = documentContext.read("$.win");
        assertThat(win).isEqualTo(newGameRecord.win());
        Boolean lose = documentContext.read("$.lose");
        assertThat(lose).isEqualTo(newGameRecord.lose());
        Boolean draw = documentContext.read("$.draw");
        assertThat(draw).isEqualTo(newGameRecord.draw());
        String gameDateTimeString = documentContext.read("$.gameDateTime");
        LocalDateTime gameDateTime = LocalDateTime.parse(gameDateTimeString).truncatedTo(ChronoUnit.MILLIS);
        assertThat(gameDateTime).isEqualTo(newGameRecord.gameDateTime().truncatedTo(ChronoUnit.MILLIS));
    }
}