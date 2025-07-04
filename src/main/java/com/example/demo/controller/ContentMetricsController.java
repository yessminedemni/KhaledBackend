package com.example.demo.controller;

import com.example.demo.entities.ContentMetrics;
import com.example.demo.service.ContentMetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content-metrics")
@CrossOrigin
public class ContentMetricsController {

    private final ContentMetricsService contentMetricsService;

    public ContentMetricsController(ContentMetricsService contentMetricsService) {
        this.contentMetricsService = contentMetricsService;
    }

    @PostMapping
    public ResponseEntity<ContentMetrics> create(@RequestBody ContentMetrics metrics) {
        return ResponseEntity.status(201).body(contentMetricsService.save(metrics));
    }

    @GetMapping
    public List<ContentMetrics> getAll() {
        return contentMetricsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentMetrics> getById(@PathVariable Long id) {
        ContentMetrics metric = contentMetricsService.findById(id);
        return metric != null ? ResponseEntity.ok(metric) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentMetrics> update(@PathVariable Long id, @RequestBody ContentMetrics updated) {
        ContentMetrics metric = contentMetricsService.update(id, updated);
        return metric != null ? ResponseEntity.ok(metric) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contentMetricsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
