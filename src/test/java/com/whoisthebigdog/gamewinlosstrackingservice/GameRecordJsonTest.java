package com.whoisthebigdog.gamewinlosstrackingservice;

import com.whoisthebigdog.gamewinlosstrackingservice.models.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class GameRecordJsonTest {

    // Figure out exactly what this is doing.
    @Autowired
    private JacksonTester<GameRecord> json;

    // @Autowired
    // private JacksonTester<CashCard[]> jsonList;

    // private CashCard[] cashCards;
    private GameRecord[] gameRecords;

    // @BeforeEach
    // void setUp() {
    //     cashCards = Arrays.array(
    //             new CashCard(99L, 123.45, "sarah1"),
    //             new CashCard(100L, 1.00, "sarah1"),
    //             new CashCard(101L, 150.00, "sarah1"));
    // }
    @BeforeEach
    void setUp() {
        gameRecords = Arrays.array(
            new GameRecord(1L, 
                new Game(1L, "Rocket League"), 
                new Team(1L, "Uh Oh Boys", "Jeff", "Alex", "Drew", null, null, null, null, null, null, null), 
                false, 
                false, 
                false, 
                new Date()));
    }

    // TODO: Finish writing this method
    @Test
    public void gameRecordSerializationTest() throws IOException {
        GameRecord gameRecord = gameRecords[0];
        System.out.println(json.write(gameRecord));
    }
    // @Test
    // public void cashCardSerializationTest() throws IOException {
    //     CashCard cashCard = cashCards[0];
    //     assertThat(json.write(cashCard)).isStrictlyEqualToJson("single.json");
    //     assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
    //     assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
    //             .isEqualTo(99);
    //     assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
    //     assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
    //             .isEqualTo(123.45);
    // }

    // @Test
    // void cashCardListSerializationTest() throws IOException {
    //     assertThat(jsonList.write(cashCards)).isStrictlyEqualToJson("list.json");
    // }   

    // @Test
    // void cashCardListDeserializationTest() throws IOException {
    //     String expected = """
    //             [
    //                  {"id": 99, "amount": 123.45 , "owner": "sarah1"},
    //                  {"id": 100, "amount": 1.00 , "owner": "sarah1"},
    //                  {"id": 101, "amount": 150.00, "owner": "sarah1"}
                                                  
    //             ]
    //             """;
    //     assertThat(jsonList.parse(expected)).isEqualTo(cashCards);
    // }

    // @Test
    // public void cashCardDeserializationTest() throws IOException {
    //     String expected = """
    //             {
    //                 "id": 99,
    //                 "amount": 123.45, 
    //                 "owner": "sarah1"
    //             }
    //             """;
    //     assertThat(json.parse(expected))
    //             .isEqualTo(new CashCard(99L, 123.45, "sarah1"));
    //     assertThat(json.parseObject(expected).id()).isEqualTo(99L);
    //     assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
    // }
}
