package com.whoisthebigdog.gamewinlosstrackingservice;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.whoisthebigdog.gamewinlosstrackingservice.models.Game;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameApiTest {
    
    @Autowired
    TestRestTemplate restTemplate;
    @Test
    void shouldReturnAGameWithAKnownId() {
        ResponseEntity<String> response = restTemplate
        .getForEntity("/games/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.gameId");
        assertThat(id).isEqualTo(1);
        String gameName = documentContext.read("$.gameName");
        assertThat(gameName).isEqualTo("unit_test_game_01");
    }

    @Test
    void shouldNotReturnAGameWithAnUnknownId() {
        ResponseEntity<String> response = restTemplate
        .getForEntity("/games/10000", String.class);
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
        assertThat(newGame.gameName()).isEqualTo(gameName);
    }
}
