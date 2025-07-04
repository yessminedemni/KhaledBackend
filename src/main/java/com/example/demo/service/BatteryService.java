package com.example.demo.service;

import com.example.demo.entities.Battery;
import com.example.demo.repositories.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryService {

    private final BatteryRepository batteryRepository;

    @Autowired
    public BatteryService(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    public Battery save(Battery battery) {
        return batteryRepository.save(battery);
    }

    public List<Battery> findAll() {
        return batteryRepository.findAll();
    }

    public Battery findById(Long id) {
        return batteryRepository.findById(id).orElse(null);
    }

    public Battery update(Long id, Battery updatedBattery) {
        return batteryRepository.findById(id).map(existing -> {
            existing.setBatteryType(updatedBattery.getBatteryType());
            existing.setCapacity(updatedBattery.getCapacity());
            existing.setVoltage(updatedBattery.getVoltage());
            existing.setCurrentCharge(updatedBattery.getCurrentCharge());
            existing.setStatus(updatedBattery.getStatus());
            existing.setManufacturer(updatedBattery.getManufacturer());
            existing.setModel(updatedBattery.getModel());
            existing.setSerialNumber(updatedBattery.getSerialNumber());
            existing.setChemistry(updatedBattery.getChemistry());
            existing.setChargeVoltage(updatedBattery.getChargeVoltage());
            existing.setDischargeVoltage(updatedBattery.getDischargeVoltage());
            existing.setMaxChargeCurrent(updatedBattery.getMaxChargeCurrent());
            existing.setMaxDischargeCurrent(updatedBattery.getMaxDischargeCurrent());
            existing.setOperatingTemperature(updatedBattery.getOperatingTemperature());
            existing.setStorageTemperature(updatedBattery.getStorageTemperature());
            existing.setDesignLife(updatedBattery.getDesignLife());
            existing.setCycleLife(updatedBattery.getCycleLife());
            existing.setCurrentCycleCount(updatedBattery.getCurrentCycleCount());
            existing.setStateOfHealth(updatedBattery.getStateOfHealth());
            existing.setInternalResistance(updatedBattery.getInternalResistance());
            existing.setInstallationDate(updatedBattery.getInstallationDate());
            existing.setLastMaintenanceDate(updatedBattery.getLastMaintenanceDate());
            existing.setNextMaintenanceDate(updatedBattery.getNextMaintenanceDate());
            existing.setMaintenanceNotes(updatedBattery.getMaintenanceNotes());
            existing.setHasGPSTracking(updatedBattery.getHasGPSTracking());
            existing.setHasTheftDetection(updatedBattery.getHasTheftDetection());
            existing.setCertifications(updatedBattery.getCertifications());
            existing.setWeight(updatedBattery.getWeight());
            existing.setDimensions(updatedBattery.getDimensions());
            existing.setPowerSystem(updatedBattery.getPowerSystem());
            return batteryRepository.save(existing);
        }).orElse(null);
    }

    public void delete(Long id) {
        batteryRepository.deleteById(id);
    }
}
