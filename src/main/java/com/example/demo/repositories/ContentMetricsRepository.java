package com.example.demo.repositories;

import com.example.demo.entities.ContentMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentMetricsRepository extends JpaRepository<ContentMetrics, Long> {
}
