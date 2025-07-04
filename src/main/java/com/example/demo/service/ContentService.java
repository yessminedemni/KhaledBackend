package com.example.demo.service;

import com.example.demo.entities.Content;
import com.example.demo.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Content save(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    public Content findById(Long id) {
        return contentRepository.findById(id).orElse(null);
    }

    public Content update(Long id, Content updated) {
        return contentRepository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setFilePath(updated.getFilePath());
            existing.setStartTime(updated.getStartTime());
            existing.setEndTime(updated.getEndTime());
            existing.setDuration(updated.getDuration());
            existing.setStatus(updated.getStatus());
            existing.setPriority(updated.getPriority());
            existing.setDescription(updated.getDescription());
            existing.setCategory(updated.getCategory());
            existing.setTags(updated.getTags());
            existing.setTargetAudience(updated.getTargetAudience());
            existing.setContentFormat(updated.getContentFormat());
            existing.setResolution(updated.getResolution());
            existing.setFileSize(updated.getFileSize());
            existing.setChecksum(updated.getChecksum());
            existing.setCreatedBy(updated.getCreatedBy());
            existing.setApprovedBy(updated.getApprovedBy());
            existing.setApprovalDate(updated.getApprovalDate());
            existing.setApprovalNotes(updated.getApprovalNotes());
            existing.setPlaybackSchedule(updated.getPlaybackSchedule());
            existing.setPlaybackFrequency(updated.getPlaybackFrequency());
            existing.setPlaybackDays(updated.getPlaybackDays());
            existing.setPlaybackHours(updated.getPlaybackHours());
            existing.setAdvertisingClient(updated.getAdvertisingClient());
            existing.setAdvertisingCampaign(updated.getAdvertisingCampaign());
            existing.setAdvertisingRate(updated.getAdvertisingRate());
            existing.setAdvertisingContract(updated.getAdvertisingContract());
            existing.setContentRating(updated.getContentRating());
            existing.setContentLanguage(updated.getContentLanguage());
            existing.setContentRegion(updated.getContentRegion());
            existing.setWeatherConditions(updated.getWeatherConditions());
            existing.setTrafficConditions(updated.getTrafficConditions());
            existing.setEventTriggers(updated.getEventTriggers());
            existing.setInteractiveElements(updated.getInteractiveElements());
            existing.setAudioEnabled(updated.getAudioEnabled());
            existing.setSubtitlesEnabled(updated.getSubtitlesEnabled());
            existing.setClosedCaptioning(updated.getClosedCaptioning());
            existing.setAccessibilityFeatures(updated.getAccessibilityFeatures());
            existing.setVersionNumber(updated.getVersionNumber());
            existing.setChangeLog(updated.getChangeLog());
            existing.setBackupCopies(updated.getBackupCopies());
            existing.setDistributionMethod(updated.getDistributionMethod());
            existing.setContentLicense(updated.getContentLicense());
            existing.setCopyrightInfo(updated.getCopyrightInfo());
            existing.setTermsOfUse(updated.getTermsOfUse());
            existing.setPrivacyPolicy(updated.getPrivacyPolicy());
            existing.setDataRetention(updated.getDataRetention());
            existing.setArchivePolicy(updated.getArchivePolicy());
            existing.setPerformanceMetrics(updated.getPerformanceMetrics());
            existing.setViewerEngagement(updated.getViewerEngagement());
            existing.setConversionRate(updated.getConversionRate());
            existing.setRevenueGenerated(updated.getRevenueGenerated());
            existing.setDisplay(updated.getDisplay());
            existing.setCreatedByUser(updated.getCreatedByUser());
            existing.setApprovedByUser(updated.getApprovedByUser());
            existing.setContentMetrics(updated.getContentMetrics());
            return contentRepository.save(existing);
        }).orElse(null);
    }

    public void delete(Long id) {
        contentRepository.deleteById(id);
    }
}
