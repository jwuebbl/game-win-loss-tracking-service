// package com.whoisthebigdog.gamewinlosstrackingservice;

// import com.jayway.jsonpath.DocumentContext;
// import com.jayway.jsonpath.JsonPath;
// import com.whoisthebigdog.gamewinlosstrackingservice.models.Team;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import static org.assertj.core.api.Assertions.assertThat;

// import java.net.URI;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// public class TeamApiTest {
    
//     @Autowired
//     TestRestTemplate restTemplate;

//     @Test
//     void shouldReturnATeamWithAKnownId() {
//         ResponseEntity<String> response = restTemplate
//         .getForEntity("/teams/5", String.class);
//         assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//         DocumentContext documentContext = JsonPath.parse(response.getBody());
//         Number id = documentContext.read("$.teamId");
//         assertThat(id).isEqualTo(5);
//         String teamName = documentContext.read("$.teamName");
//         assertThat(teamName).isEqualTo("Uh Oh Boyz");
//         String teamMember01 = documentContext.read("$.teamMember_01");
//         assertThat(teamMember01).isEqualTo("Alex");
//         String teamMember02 = documentContext.read("$.teamMember_02");
//         assertThat(teamMember02).isEqualTo("Drew");
//         String teamMember03 = documentContext.read("$.teamMember_03");
//         assertThat(teamMember03).isEqualTo("Jeff");
//     }

//     @Test
//     void shouldNotReturnATeamWithAnUnknownId() {
//         ResponseEntity<String> response = restTemplate
//         .getForEntity("/teams/1000", String.class);
//         assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//         assertThat(response.getBody()).isBlank();
//     }

//     @Test
//     void shouldCreateANewTeam() {
//         Team newTeam = new Team(null, "unitTestTeam", "teamMember01", "teamMember02", "teamMember03", null, null, null, null, null, null, null);
//         ResponseEntity<Void> createResponse = restTemplate.postForEntity("/teams", newTeam, Void.class);
//         assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//         URI locationOfNewTeam = createResponse.getHeaders().getLocation();
//         ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewTeam, String.class);
//         assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//         DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
//         Number teamId = documentContext.read("$.teamId");
//         assertThat(teamId).isNotNull();
//         String teamName = documentContext.read("$.teamName");
//         assertThat(newTeam.teamName()).isEqualTo(teamName);
//         String teamMember01 = documentContext.read("$.teamMember_01");
//         assertThat(newTeam.teamMember_01()).isEqualTo(teamMember01);
//         String teamMember02 = documentContext.read("$.teamMember_02");
//         assertThat(newTeam.teamMember_02()).isEqualTo(teamMember02);
//         String teamMember03 = documentContext.read("$.teamMember_03");
//         assertThat(newTeam.teamMember_03()).isEqualTo(teamMember03);
//     }
// }