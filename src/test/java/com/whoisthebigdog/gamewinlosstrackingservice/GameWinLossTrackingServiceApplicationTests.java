package com.whoisthebigdog.gamewinlosstrackingservice;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.whoisthebigdog.gamewinlosstrackingservice.models.Game;
import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;
import com.whoisthebigdog.gamewinlosstrackingservice.models.Team;
import com.whoisthebigdog.gamewinlosstrackingservice.repositories.GameRecordRepository;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameWinLossTrackingServiceApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    private GameRecordRepository gameRecordRepository;

    @Test
    void shouldReturnAGameRecord() {
        ResponseEntity<String> response = restTemplate
			.getForEntity("/gamerecords/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // DocumentContext documentContext = JsonPath.parse(response.getBody());
        // Number id = documentContext.read("$.id");
        // assertThat(id).isEqualTo(99);

        // Double amount = documentContext.read("$.amount");
        // assertThat(amount).isEqualTo(123.45);
    }
}