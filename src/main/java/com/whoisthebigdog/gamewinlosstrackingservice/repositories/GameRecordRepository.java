package com.whoisthebigdog.gamewinlosstrackingservice.repositories;

import com.whoisthebigdog.gamewinlosstrackingservice.models.GameRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRecordRepository extends CrudRepository<GameRecord, Long> {
}
