package com.example.demo.controller;

import com.example.demo.entities.Tower;
import com.example.demo.service.TowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/towers")
@CrossOrigin
public class TowerController {

    private final TowerService towerService;

    public TowerController(TowerService towerService) {
        this.towerService = towerService;
    }

    @PostMapping
    public ResponseEntity<Tower> create(@RequestBody Tower tower) {
        return ResponseEntity.status(201).body(towerService.save(tower));
    }

    @GetMapping
    public List<Tower> getAll() {
        return towerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tower> getById(@PathVariable Long id) {
        Tower tower = towerService.findById(id);
        return tower != null ? ResponseEntity.ok(tower) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tower> update(@PathVariable Long id, @RequestBody Tower updatedTower) {
        Tower tower = towerService.update(id, updatedTower);
        return tower != null ? ResponseEntity.ok(tower) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        towerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
