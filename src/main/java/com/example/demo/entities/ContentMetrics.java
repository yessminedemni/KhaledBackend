package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "content_metrics")
public class ContentMetrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metricId;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String metricType; // VIEWS, DURATION, ENGAGEMENT, CONVERSION

    @Column(nullable = false)
    private Double value;

    private String unit;
    private String source;
    private String location;
    private String demographics;
    private String deviceType;
    private String sessionId;
    private String userAgent;
    private String ipAddress;
    private String referrer;
    private String campaignId;
    private String experimentId;
    private String segmentId;
    private String conversionType;
    private String conversionValue;
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Content content;


}