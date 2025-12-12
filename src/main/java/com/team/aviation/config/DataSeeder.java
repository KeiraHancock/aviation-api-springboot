package com.team.aviation.config;

import com.team.aviation.entity.*;
import com.team.aviation.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final AirportRepo airportRepo;
    private final AirlineRepo airlineRepo;
    private final GateRepo gateRepo;
    private final FlightRepo flightRepo;

    @Override
    public void run(String... args) {
        if (!airportRepo.findAll().isEmpty()) return;

        Airport yhz = airportRepo.save(Airport.builder().code("YHZ").name("Halifax Stanfield").city("Halifax").build());
        Airport yyt = airportRepo.save(Airport.builder().code("YYT").name("St. John's").city("St. John's").build());

        Airline ac = airlineRepo.save(Airline.builder().code("AC").name("Air Canada").build());
        Airline ws = airlineRepo.save(Airline.builder().code("WS").name("WestJet").build());

        Gate a1 = gateRepo.save(Gate.builder().gateNumber("A1").airport(yhz).build());
        Gate b2 = gateRepo.save(Gate.builder().gateNumber("B2").airport(yhz).build());
        Gate c3 = gateRepo.save(Gate.builder().gateNumber("C3").airport(yyt).build());

        flightRepo.save(Flight.builder()
                .flightNumber("AC123")
                .type("ARRIVAL")
                .scheduledTime(OffsetDateTime.now().plusHours(2))
                .airport(yhz)
                .airline(ac)
                .gate(a1)
                .originOrDestination("Toronto")
                .status("SCHEDULED")
                .build());

        flightRepo.save(Flight.builder()
                .flightNumber("WS204")
                .type("DEPARTURE")
                .scheduledTime(OffsetDateTime.now().plusHours(3))
                .airport(yhz)
                .airline(ws)
                .gate(b2)
                .originOrDestination("Montreal")
                .status("BOARDING")
                .build());

        flightRepo.save(Flight.builder()
                .flightNumber("AC88")
                .type("ARRIVAL")
                .scheduledTime(OffsetDateTime.now().plusHours(1))
                .airport(yyt)
                .airline(ac)
                .gate(c3)
                .originOrDestination("Halifax")
                .status("DELAYED")
                .build());
    }
}
