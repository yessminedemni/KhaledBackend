package com.example.demo.controller;

import com.example.demo.entities.LEDDisplay;
import com.example.demo.service.LEDDisplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/led-displays")
@CrossOrigin
public class LEDDisplayController {

    private final LEDDisplayService ledDisplayService;

    public LEDDisplayController(LEDDisplayService ledDisplayService) {
        this.ledDisplayService = ledDisplayService;
    }

    @PostMapping
    public ResponseEntity<LEDDisplay> create(@RequestBody LEDDisplay display) {
        return ResponseEntity.status(201).body(ledDisplayService.save(display));
    }

    @GetMapping
    public List<LEDDisplay> getAll() {
        return ledDisplayService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LEDDisplay> getById(@PathVariable Long id) {
        LEDDisplay display = ledDisplayService.findById(id);
        return display != null ? ResponseEntity.ok(display) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LEDDisplay> update(@PathVariable Long id, @RequestBody LEDDisplay updated) {
        LEDDisplay display = ledDisplayService.update(id, updated);
        return display != null ? ResponseEntity.ok(display) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ledDisplayService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
