package com.whoisthebigdog.gamewinlosstrackingservice.repositories;


import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;



public interface GameRecordRepository extends CrudRepository<GameRecord, Long> {

    // Overriding the default findById method
    @Query(value = "SELECT * FROM game_record WHERE gameRecordID = :id")
    Optional<GameRecord> findById(@Param("id") Long gameRecordID);
}
