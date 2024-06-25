package ro.bodystats.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.bodystats.model.BodyStats;
import ro.bodystats.service.BodyStatsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/bodystats")
public class BodyStatsController {
    @Autowired
    private BodyStatsService bodyStatsService;
    private static final Logger logger = LoggerFactory.getLogger(BodyStatsController.class);
    private final UUID PROFILE_ID = UUID.randomUUID();

    @GetMapping
    public String getLastBodyStats(Model model) {
        BodyStats bodyStats = bodyStatsService.getLastBodyStats(PROFILE_ID);
        model.addAttribute("bodyStats", bodyStats);
        model.addAttribute("profileId", PROFILE_ID);
        return "/bodystats/index";
    }

    @GetMapping("/history")
    public String getBodyStatsHistory(Model model) {
        List<BodyStats> bodyStatsList = bodyStatsService.getBodyStatsByProfileId(PROFILE_ID);
        model.addAttribute("bodyStatsList", bodyStatsList);
        model.addAttribute("profileId", PROFILE_ID);
        return "/bodystats/history";
    }

    @GetMapping("/{id}")
    public String getBodyStatsById(@PathVariable UUID id, Model model) {
        Optional<BodyStats> bodyStats = bodyStatsService.getBodyStatsById(id);
        model.addAttribute("bodyStats", bodyStats.orElse(null));
        model.addAttribute("profileId", PROFILE_ID);
        return "/bodystats/details";
    }

    @GetMapping("/new")
    public String showNewBodyStatsForm(Model model) {
        BodyStats bodyStats = new BodyStats();
        bodyStats.setProfileId(PROFILE_ID);
        model.addAttribute("bodyStats", bodyStats);
        model.addAttribute("profileId", PROFILE_ID);
        return "/bodystats/new";
    }

    @PostMapping("/new")
    public String createNewBodyStats(@ModelAttribute BodyStats bodyStats) {
        logger.info("Received profileId: {}", PROFILE_ID);
        bodyStats.setProfileId(PROFILE_ID);
        bodyStatsService.saveBodyStats(bodyStats);
        return "/bodystats/index";
    }
}
