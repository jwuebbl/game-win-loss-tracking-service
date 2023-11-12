package com.whoisthebigdog.gamewinlosstrackingservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;

import java.util.Optional;

public interface GameRecordRepository extends CrudRepository<GameRecord, Long> {
    Optional<GameRecord> findByGameRecordID(Long gameRecordID);
}
