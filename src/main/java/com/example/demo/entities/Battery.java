package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "batteries")
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batteryId;

    @Column(nullable = false)
    private String batteryType; // NMC, LiFePO4, etc.

    @Column(nullable = false)
    private Integer capacity; // Ah

    @Column(nullable = false)
    private Double voltage; // V

    @Column(nullable = false)
    private Double currentCharge; // Current charge percentage

    @Enumerated(EnumType.STRING)
    private BatteryStatus status; // CHARGING, DISCHARGING, FULL, LOW, FAULT

    private String manufacturer;
    private String model;
    private String serialNumber;
    private String chemistry;
    private Double chargeVoltage;
    private Double dischargeVoltage;
    private Double maxChargeCurrent;
    private Double maxDischargeCurrent;
    private String operatingTemperature;
    private String storageTemperature;
    private Integer designLife; // years
    private Integer cycleLife;
    private Integer currentCycleCount;
    private Double stateOfHealth; // %
    private Double internalResistance;
    private LocalDateTime installationDate;
    private LocalDateTime lastMaintenanceDate;
    private LocalDateTime nextMaintenanceDate;
    private String maintenanceNotes;
    private Boolean hasGPSTracking;
    private Boolean hasTheftDetection;
    private String certifications;
    private Double weight;
    private String dimensions;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private PowerSystem powerSystem;

    @OneToMany(mappedBy = "battery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BatteryMetrics> batteryMetrics = new ArrayList<>();

}