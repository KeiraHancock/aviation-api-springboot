package com.team.aviation;

import com.team.aviation.entity.Airline;
import com.team.aviation.entity.Airport;
import com.team.aviation.entity.Flight;
import com.team.aviation.entity.Gate;
import com.team.aviation.repo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlightRepoTest {

    @Autowired AirportRepo airportRepo;
    @Autowired AirlineRepo airlineRepo;
    @Autowired GateRepo gateRepo;
    @Autowired FlightRepo flightRepo;

    @Test
    void canFindFlightsByAirportCode() {
        Airport a = airportRepo.save(Airport.builder().code("TEST").name("Test Airport").city("Test City").build());
        Airline al = airlineRepo.save(Airline.builder().code("TT").name("Test Air").build());
        Gate g = gateRepo.save(Gate.builder().gateNumber("T1").airport(a).build());

        flightRepo.save(Flight.builder()
                .flightNumber("TT100")
                .type("ARRIVAL")
                .scheduledTime(OffsetDateTime.now().plusHours(1))
                .airport(a)
                .airline(al)
                .gate(g)
                .originOrDestination("Nowhere")
                .status("SCHEDULED")
                .build());

        var flights = flightRepo.findByAirport_CodeOrderByScheduledTimeAsc("TEST");
        assertThat(flights).isNotEmpty();
        assertThat(flights.get(0).getFlightNumber()).isEqualTo("TT100");
    }
}
