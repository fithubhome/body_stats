package com.bodystats.api.service;

import com.bodystats.api.model.BodyStats;
import com.bodystats.api.repository.BodyStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BodyStatsService {
    @Autowired
    private BodyStatsRepository bodyStatsRepository;

    public List<BodyStats> getBodyStatsByProfileId(UUID profileId) {
        return bodyStatsRepository.findByProfileIdOrderByRegisterDayDesc(profileId);
    }

    public Optional<BodyStats> getBodyStatsById(UUID id) {
        return bodyStatsRepository.findById(id);
    }

    public BodyStats getLastBodyStats(UUID profileId) {
        List<BodyStats> bodyStatsList = bodyStatsRepository.findByProfileIdOrderByRegisterDayDesc(profileId);
        return bodyStatsList.isEmpty() ? null : bodyStatsList.get(0);
    }

    public void saveBodyStats(BodyStats bodyStats) {
        bodyStatsRepository.save(bodyStats);
    }
}
