package com.whoisthebigdog.gamewinlosstrackingservice;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameWinLossTrackingServiceApplicationTest {
    
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
        assertThat(gameName).isEqualTo("Golf");
    }

    @Test
    void shouldNotReturnAGameWithAnUnknownId() {
        ResponseEntity<String> response = restTemplate
        .getForEntity("/games/1000", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isBlank();
    }


}