package com.whoisthebigdog.gamewinlosstrackingservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.whoisthebigdog.gamewinlosstrackingservice.models.Game;

public interface GameRepository extends CrudRepository<Game, Long>{}