package com.team.aviation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String flightNumber; // e.g. AC123

    @NotBlank
    @Column(nullable = false)
    private String type; // ARRIVAL or DEPARTURE (keep simple for now)

    @NotNull
    @Column(nullable = false)
    private OffsetDateTime scheduledTime;

    @ManyToOne(optional = false)
    private Airport airport; // the airport showing this board

    @ManyToOne(optional = false)
    private Airline airline;

    @ManyToOne(optional = false)
    private Gate gate;

    @NotBlank
    @Column(nullable = false)
    private String originOrDestination; // "Toronto" for arrival, "London" for departure

    @NotBlank
    @Column(nullable = false)
    private String status; // SCHEDULED, DELAYED, LANDED, BOARDING, etc.
}
