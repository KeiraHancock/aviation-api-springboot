package com.team.aviation.controller;

import com.team.aviation.entity.Gate;
import com.team.aviation.repo.GateRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gates")
@CrossOrigin(origins = "*")
public class GateController {

    private final GateRepo repo;

    @GetMapping public List<Gate> all(){ return repo.findAll(); }
    @PostMapping public Gate create(@Valid @RequestBody Gate g){ return repo.save(g); }
    @PutMapping("/{id}") public Gate update(@PathVariable Long id, @Valid @RequestBody Gate g){
        Gate e = repo.findById(id).orElseThrow();
        e.setGateNumber(g.getGateNumber());
        e.setAirport(g.getAirport());
        return repo.save(e);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
