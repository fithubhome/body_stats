package ro.bodystats.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.bodystats.model.BodyStats;
import ro.bodystats.service.BodyStatsService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bodystats")
public class BodyStatsController {
    @Autowired
    private BodyStatsService bodyStatsService;

    private static final Logger logger = LoggerFactory.getLogger(BodyStatsController.class);

    @PostMapping
    public BodyStats getLastBodyStats(@RequestBody UUID profileId) {
        BodyStats bodyStats = bodyStatsService.getLastBodyStats(profileId);
        if (bodyStats == null) {
            logger.info("No body stats found for profile ID: {}", profileId);
            bodyStats = new BodyStats();
            bodyStats.setId(UUID.randomUUID());
            bodyStats.setProfileId(profileId);
            bodyStats.setRegisterDay(new Date());
            bodyStats.setBmi(17.0);
            bodyStats.setWeight(61.0);
            bodyStats.setMuscleMass(27.1);
            bodyStats.setFatPercentage(12.2);
            bodyStatsService.saveBodyStats(bodyStats);
            logger.info("Just created a basic bodystats profile: {}", profileId);
        }
        return bodyStats;
    }

    @PostMapping("/history")
    public List<BodyStats> getBodyStatsHistory(@RequestBody UUID profileId) {
        return bodyStatsService.getBodyStatsByProfileId(profileId);
    }

    @GetMapping("/{id}")
    public BodyStats getBodyStatsById(@PathVariable UUID id) {
        Optional<BodyStats> bodyStats = bodyStatsService.getBodyStatsById(id);
        return bodyStats.orElse(null);
    }

    @PostMapping("/new")
    public void createNewBodyStats(@RequestBody BodyStats bodyStats) {
        bodyStatsService.saveBodyStats(bodyStats);
    }
}
