package com.example.demo.entities;

import jakarta.persistence.*;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//contentId
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private Integer duration; // seconds

    @Enumerated(EnumType.STRING)
    private ContentStatus status; // SCHEDULED, ACTIVE, EXPIRED, PAUSED

    @Column(nullable = false)
    private Integer priority;

    private String description;
    private String category;
    private String tags;
    private String targetAudience;
    private String contentFormat;
    private String resolution;
    private String fileSize;
    private String checksum;
    private String createdBy;
    private String approvedBy;
    private LocalDateTime approvalDate;
    private String approvalNotes;
    private String playbackSchedule;
    private String playbackFrequency;
    private String playbackDays;
    private String playbackHours;
    private String advertisingClient;
    private String advertisingCampaign;
    private Double advertisingRate;
    private String advertisingContract;
    private String contentRating;
    private String contentLanguage;
    private String contentRegion;
    private String weatherConditions;
    private String trafficConditions;
    private String eventTriggers;
    private String interactiveElements;
    private String audioEnabled;
    private String subtitlesEnabled;
    private String closedCaptioning;
    private String accessibilityFeatures;
    private String versionNumber;
    private String changeLog;
    private String backupCopies;
    private String distributionMethod;
    private String contentLicense;
    private String copyrightInfo;
    private String termsOfUse;
    private String privacyPolicy;
    private String dataRetention;
    private String archivePolicy;
    private String performanceMetrics;
    private String viewerEngagement;
    private String conversionRate;
    private String revenueGenerated;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private LEDDisplay display;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdByUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private User approvedByUser;

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContentMetrics> contentMetrics = new ArrayList<>();

}