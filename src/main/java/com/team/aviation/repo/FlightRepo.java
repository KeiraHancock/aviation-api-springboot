package com.team.aviation.repo;

import com.team.aviation.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepo extends JpaRepository<Flight, Long> {
    List<Flight> findByAirport_CodeOrderByScheduledTimeAsc(String airportCode);
}
