package com.example.demo.controller;

import com.example.demo.entities.PowerSystem;
import com.example.demo.service.PowerSystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/power-systems")

@CrossOrigin
public class PowerSystemController {

    private final PowerSystemService powerSystemService;

    public PowerSystemController(PowerSystemService powerSystemService) {
        this.powerSystemService = powerSystemService;
    }

    @PostMapping
    public ResponseEntity<PowerSystem> create(@RequestBody PowerSystem system) {
        return ResponseEntity.status(201).body(powerSystemService.save(system));
    }

    @GetMapping
    public List<PowerSystem> getAll() {
        return powerSystemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PowerSystem> getById(@PathVariable Long id) {
        PowerSystem system = powerSystemService.findById(id);
        return system != null ? ResponseEntity.ok(system) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PowerSystem> update(@PathVariable Long id, @RequestBody PowerSystem updated) {
        PowerSystem system = powerSystemService.update(id, updated);
        return system != null ? ResponseEntity.ok(system) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        powerSystemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
