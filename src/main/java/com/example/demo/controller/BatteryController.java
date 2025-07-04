package com.example.demo.controller;

import com.example.demo.entities.Battery;
import com.example.demo.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
@RequiredArgsConstructor
@CrossOrigin
public class BatteryController {

    private final BatteryService batteryService;

    @PostMapping
    public ResponseEntity<Battery> create(@RequestBody Battery battery) {
        return ResponseEntity.status(201).body(batteryService.save(battery));
    }

    @GetMapping
    public List<Battery> getAll() {
        return batteryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Battery> getById(@PathVariable Long id) {
        Battery battery = batteryService.findById(id);
        return battery != null ? ResponseEntity.ok(battery) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Battery> update(@PathVariable Long id, @RequestBody Battery updated) {
        Battery battery = batteryService.update(id, updated);
        return battery != null ? ResponseEntity.ok(battery) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        batteryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
