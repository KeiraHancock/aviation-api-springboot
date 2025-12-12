package com.team.aviation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String code; // e.g. YHZ

    @NotBlank
    @Column(nullable = false)
    private String name; // e.g. Halifax Stanfield

    @NotBlank
    @Column(nullable = false)
    private String city;
}
