package com.team.aviation.controller;

import com.team.aviation.entity.Airline;
import com.team.aviation.repo.AirlineRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airlines")
@CrossOrigin(origins = "*")
public class AirlineController {

    private final AirlineRepo repo;

    @GetMapping public List<Airline> all(){ return repo.findAll(); }
    @PostMapping public Airline create(@Valid @RequestBody Airline a){ return repo.save(a); }
    @PutMapping("/{id}") public Airline update(@PathVariable Long id, @Valid @RequestBody Airline a){
        Airline e = repo.findById(id).orElseThrow();
        e.setCode(a.getCode()); e.setName(a.getName());
        return repo.save(e);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
