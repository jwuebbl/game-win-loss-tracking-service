package com.whoisthebigdog.gamewinlosstrackingservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.whoisthebigdog.gamewinlosstrackingservice.models.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{}