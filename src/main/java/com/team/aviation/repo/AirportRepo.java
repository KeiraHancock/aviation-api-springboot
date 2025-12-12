package com.team.aviation.repo;

import com.team.aviation.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepo extends JpaRepository<Airport, Long> {
    Optional<Airport> findByCode(String code);
}
