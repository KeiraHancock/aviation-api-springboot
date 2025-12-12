package com.team.aviation.controller;

import com.team.aviation.entity.Flight;
import com.team.aviation.repo.FlightRepo;
import com.team.aviation.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*")
public class FlightController {

    private final FlightService flightService;
    private final FlightRepo flightRepo;

    @GetMapping
    public List<Flight> all() {
        return flightRepo.findAll();
    }

    @GetMapping("/airport/{airportCode}")
    public List<Flight> byAirport(@PathVariable String airportCode) {
        return flightService.getFlightsForAirport(airportCode);
    }

    @PostMapping
    public Flight create(@Valid @RequestBody Flight flight) {
        return flightService.create(flight);
    }

    @PutMapping("/{id}")
    public Flight update(@PathVariable Long id, @Valid @RequestBody Flight flight) {
        return flightService.update(id, flight);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        flightService.delete(id);
    }
}
