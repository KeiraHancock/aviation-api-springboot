package com.team.aviation.service;

import com.team.aviation.entity.Flight;
import com.team.aviation.repo.FlightRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepo flightRepo;

    public List<Flight> getFlightsForAirport(String airportCode) {
        return flightRepo.findByAirport_CodeOrderByScheduledTimeAsc(airportCode);
    }

    public Flight create(Flight flight) {
        return flightRepo.save(flight);
    }

    public Flight update(Long id, Flight updated) {
        Flight existing = flightRepo.findById(id).orElseThrow();
        existing.setFlightNumber(updated.getFlightNumber());
        existing.setType(updated.getType());
        existing.setScheduledTime(updated.getScheduledTime());
        existing.setAirport(updated.getAirport());
        existing.setAirline(updated.getAirline());
        existing.setGate(updated.getGate());
        existing.setOriginOrDestination(updated.getOriginOrDestination());
        existing.setStatus(updated.getStatus());
        return flightRepo.save(existing);
    }

    public void delete(Long id) {
        flightRepo.deleteById(id);
    }
}
