package com.team.aviation.controller;

import com.team.aviation.entity.Airport;
import com.team.aviation.repo.AirportRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airports")
@CrossOrigin(origins = "*")
public class AirportController {

    private final AirportRepo repo;

    @GetMapping public List<Airport> all(){ return repo.findAll(); }
    @PostMapping public Airport create(@Valid @RequestBody Airport a){ return repo.save(a); }
    @PutMapping("/{id}") public Airport update(@PathVariable Long id, @Valid @RequestBody Airport a){
        Airport e = repo.findById(id).orElseThrow();
        e.setCode(a.getCode()); e.setName(a.getName()); e.setCity(a.getCity());
        return repo.save(e);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
