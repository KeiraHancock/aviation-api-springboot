package com.team.aviation.repo;

import com.team.aviation.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepo extends JpaRepository<Airline, Long> {}
