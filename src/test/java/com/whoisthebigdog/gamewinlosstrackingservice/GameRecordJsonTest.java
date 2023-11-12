package com.whoisthebigdog.gamewinlosstrackingservice;

import com.whoisthebigdog.gamewinlosstrackingservice.models.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.util.Calendar;
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

    @BeforeEach
    void setUp() {
        Calendar yourCalendar = Calendar.getInstance();
        yourCalendar.set(Calendar.YEAR, 2023); // Set the year
        yourCalendar.set(Calendar.MONTH, Calendar.DECEMBER); // Set the month (Note: December is 11 as months are 0-based)
        yourCalendar.set(Calendar.DAY_OF_MONTH, 7); // Set the day of the month
        yourCalendar.set(Calendar.HOUR_OF_DAY, 4); // Set the hour of the day (24-hour format)
        yourCalendar.set(Calendar.MINUTE, 56); // Set the minute
        yourCalendar.set(Calendar.SECOND, 4); // Set the second
        yourCalendar.set(Calendar.MILLISECOND, 0); // Set the millisecond
        Date expectedDate = yourCalendar.getTime();
        gameRecords = Arrays.array(
            new GameRecord(1L, 
                new Game(1L, "Rocket League"), 
                new Team(1L, 
                    "Uh Oh Boys", 
                    "Jeff", 
                    "Alex", 
                    "Drew", 
                    null, 
                    null, 
                    null, 
                    null, 
                    null, 
                    null, 
                    null), 
                false, 
                false, 
                false, 
                expectedDate));
    }

    @Test
    public void gameRecordSerializationTest() throws IOException {
        GameRecord gameRecord = gameRecords[0];
        JsonContent<GameRecord> gameRecordJson = json.write(gameRecord);
        assertThat(gameRecordJson).isStrictlyEqualToJson("singleGameRecord.json");
        assertThat(gameRecordJson).hasJsonPathNumberValue("@.gameRecordID");
        assertThat(gameRecordJson).extractingJsonPathNumberValue("@.gameRecordID")
            .isEqualTo(1);
        assertThat(gameRecordJson).hasJsonPathNumberValue("@.game.gameID");
        assertThat(gameRecordJson).extractingJsonPathNumberValue("@.game.gameID")
            .isEqualTo(1);
        assertThat(gameRecordJson).hasJsonPathStringValue("@.game.gameName");
        assertThat(gameRecordJson).extractingJsonPathStringValue("@.game.gameName")
            .isEqualTo("Rocket League");
        assertThat(gameRecordJson).hasJsonPathNumberValue("@.team.teamID");
        assertThat(gameRecordJson).extractingJsonPathNumberValue("@.team.teamID")
            .isEqualTo(1);
        assertThat(gameRecordJson).hasJsonPathStringValue("@.team.teamName");
        assertThat(gameRecordJson).extractingJsonPathStringValue("@.team.teamName")
            .isEqualTo("Uh Oh Boys");
        assertThat(gameRecordJson).hasJsonPathStringValue("@.team.teamMember01");
        assertThat(gameRecordJson).extractingJsonPathStringValue("@.team.teamMember01")
            .isEqualTo("Jeff");
        assertThat(gameRecordJson).hasJsonPathStringValue("@.team.teamMember02");
        assertThat(gameRecordJson).extractingJsonPathStringValue("@.team.teamMember02")
            .isEqualTo("Alex");
        assertThat(gameRecordJson).hasJsonPathStringValue("@.team.teamMember03");
        assertThat(gameRecordJson).extractingJsonPathStringValue("@.team.teamMember03")
            .isEqualTo("Drew");
        assertThat(gameRecordJson).hasEmptyJsonPathValue("@.team.teamMember04");
        assertThat(gameRecordJson).hasEmptyJsonPathValue("@.team.teamMember05");
        assertThat(gameRecordJson).hasEmptyJsonPathValue("@.team.teamMember06");
        assertThat(gameRecordJson).hasEmptyJsonPathValue("@.team.teamMember07");
        assertThat(gameRecordJson).hasEmptyJsonPathValue("@.team.teamMember08");
        assertThat(gameRecordJson).hasEmptyJsonPathValue("@.team.teamMember09");
        assertThat(gameRecordJson).hasEmptyJsonPathValue("@.team.teamMember10");
        assertThat(gameRecordJson).hasJsonPathBooleanValue("@.win");
        assertThat(gameRecordJson).extractingJsonPathBooleanValue("@.win")
            .isFalse();
        assertThat(gameRecordJson).hasJsonPathBooleanValue("@.lose");
        assertThat(gameRecordJson).extractingJsonPathBooleanValue("@.lose")
            .isFalse();
        assertThat(gameRecordJson).hasJsonPathBooleanValue("@.draw");
        assertThat(gameRecordJson).extractingJsonPathBooleanValue("@.draw")
            .isFalse();
        assertThat(gameRecordJson).hasJsonPathStringValue("@.gameDateTime");
        assertThat(gameRecordJson).extractingJsonPathStringValue("@.gameDateTime")
            .isEqualTo("2023-12-07T10:56:04.000+00:00");
    }

    @Test
    public void gameRecordDeserializationTest() throws IOException {
        String expected = """
            {
                "gameRecordID":1,
                "game":{
                    "gameID":1,
                    "gameName":"Rocket League"
                },
                "team":{
                    "teamID":1,
                    "teamName":"Uh Oh Boys",
                    "teamMember01":"Jeff",
                    "teamMember02":"Alex",
                    "teamMember03":"Drew",
                    "teamMember04":null,
                    "teamMember05":null,
                    "teamMember06":null,
                    "teamMember07":null,
                    "teamMember08":null,
                    "teamMember09":null,
                    "teamMember10":null
                },
                "win":false,
                "lose":false,
                "draw":false,
                "gameDateTime":"2023-12-07T10:56:04.000+00:00"
            }
            """;
        assertThat(json.parse(expected)).isEqualTo(gameRecords[0]);
        assertThat(json.parseObject(expected).gameRecordID()).isEqualTo(1);
        assertThat(json.parseObject(expected).game().gameID()).isEqualTo(1);
        assertThat(json.parseObject(expected).game().gameName()).isEqualTo("Rocket League");
        assertThat(json.parseObject(expected).team().teamID()).isEqualTo(1);
        assertThat(json.parseObject(expected).team().teamName()).isEqualTo("Uh Oh Boys");
        assertThat(json.parseObject(expected).team().teamMember01()).isEqualTo("Jeff");
        assertThat(json.parseObject(expected).team().teamMember02()).isEqualTo("Alex");
        assertThat(json.parseObject(expected).team().teamMember03()).isEqualTo("Drew");
        assertThat(json.parseObject(expected).team().teamMember04()).isEqualTo(null);
        assertThat(json.parseObject(expected).team().teamMember05()).isEqualTo(null);
        assertThat(json.parseObject(expected).team().teamMember06()).isEqualTo(null);
        assertThat(json.parseObject(expected).team().teamMember07()).isEqualTo(null);
        assertThat(json.parseObject(expected).team().teamMember08()).isEqualTo(null);
        assertThat(json.parseObject(expected).team().teamMember09()).isEqualTo(null);
        assertThat(json.parseObject(expected).team().teamMember10()).isEqualTo(null);
        assertThat(json.parseObject(expected).win()).isEqualTo(false);
        assertThat(json.parseObject(expected).lose()).isEqualTo(false);
        assertThat(json.parseObject(expected).draw()).isEqualTo(false);
        assertThat(json.parseObject(expected).gameDateTime()).isEqualTo("2023-12-07T10:56:04.000+00:00");
    }

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
}
