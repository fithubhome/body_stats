package ro.bodystats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.bodystats.model.BodyStats;
import ro.bodystats.dto.ProfileDTO;
import ro.bodystats.repository.BodyStatsRepository;
import ro.bodystats.service.external.ExternalProfileService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BodyStatsService {

    @Autowired
    private BodyStatsRepository bodyStatsRepository;
    @Autowired
    private ExternalProfileService externalProfileService;

    public List<BodyStats> getBodyStatsByProfileId(UUID profileId) {
        // Fetch profile information to ensure it exists
        ProfileDTO profile = externalProfileService.getProfileById(profileId);
        if (profile == null) {
            throw new RuntimeException("Profile not found for ID: " + profileId);
        }
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
