package com.example.demo.controller;

import com.example.demo.entities.Content;
import com.example.demo.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping
    public ResponseEntity<Content> create(@RequestBody Content content) {
        return ResponseEntity.status(201).body(contentService.save(content));
    }

    @GetMapping
    public List<Content> getAll() {
        return contentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> getById(@PathVariable Long id) {
        Content content = contentService.findById(id);
        return content != null ? ResponseEntity.ok(content) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Content> update(@PathVariable Long id, @RequestBody Content updated) {
        Content content = contentService.update(id, updated);
        return content != null ? ResponseEntity.ok(content) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
