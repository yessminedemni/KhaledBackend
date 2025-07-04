package com.example.demo.service;

import com.example.demo.entities.ContentMetrics;
import com.example.demo.repositories.ContentMetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentMetricsService {

    private final ContentMetricsRepository repository;

    @Autowired
    public ContentMetricsService(ContentMetricsRepository repository) {
        this.repository = repository;
    }

    public ContentMetrics save(ContentMetrics metric) {
        return repository.save(metric);
    }

    public List<ContentMetrics> findAll() {
        return repository.findAll();
    }

    public ContentMetrics findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ContentMetrics update(Long id, ContentMetrics updated) {
        return repository.findById(id).map(existing -> {
            existing.setTimestamp(updated.getTimestamp());
            existing.setMetricType(updated.getMetricType());
            existing.setValue(updated.getValue());
            existing.setUnit(updated.getUnit());
            existing.setSource(updated.getSource());
            existing.setLocation(updated.getLocation());
            existing.setDemographics(updated.getDemographics());
            existing.setDeviceType(updated.getDeviceType());
            existing.setSessionId(updated.getSessionId());
            existing.setUserAgent(updated.getUserAgent());
            existing.setIpAddress(updated.getIpAddress());
            existing.setReferrer(updated.getReferrer());
            existing.setCampaignId(updated.getCampaignId());
            existing.setExperimentId(updated.getExperimentId());
            existing.setSegmentId(updated.getSegmentId());
            existing.setConversionType(updated.getConversionType());
            existing.setConversionValue(updated.getConversionValue());
            existing.setNotes(updated.getNotes());
            existing.setContent(updated.getContent());
            return repository.save(existing);
        }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
