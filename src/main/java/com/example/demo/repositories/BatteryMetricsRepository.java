package com.example.demo.repositories;

import com.example.demo.entities.BatteryMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryMetricsRepository extends JpaRepository<BatteryMetrics, Long> {
}
