package ro.bodystats.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.bodystats.model.BodyStats;
import ro.bodystats.service.BodyStatsService;
import ro.bodystats.service.external.ExternalProfileService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/bodystats")
public class BodyStatsController {
    @Autowired
    private BodyStatsService bodyStatsService;
    @Autowired
    private ExternalProfileService externalProfileService;
    private static final Logger logger = LoggerFactory.getLogger(BodyStatsController.class);

    @GetMapping("")
    public String getLastBodyStats(@RequestParam UUID profileId, Model model) {
        BodyStats bodyStats = bodyStatsService.getLastBodyStats(profileId);
        model.addAttribute("bodyStats", bodyStats);
        model.addAttribute("profileId", profileId);
        return "/bodystats/bodystats";
    }

    @GetMapping("/history")
    public String getBodyStatsHistory(@RequestParam UUID profileId, Model model) {
        List<BodyStats> bodyStatsList = bodyStatsService.getBodyStatsByProfileId(profileId);
        model.addAttribute("bodyStatsList", bodyStatsList);
        model.addAttribute("profileId", profileId);
        return "/bodystats/bodystats_history";
    }

    @GetMapping("/{id}")
    public String getBodyStatsById(@PathVariable UUID id, @RequestParam UUID profileId, Model model) {
        Optional<BodyStats> bodyStats = bodyStatsService.getBodyStatsById(id);
        model.addAttribute("bodyStats", bodyStats.orElse(null));
        model.addAttribute("profileId", profileId);
        return "/bodystats/bodystats_detail";
    }

    @GetMapping("/new")
    public String showNewBodyStatsForm(@RequestParam UUID profileId, Model model) {
        BodyStats bodyStats = new BodyStats();
        bodyStats.setProfileId(profileId);
        model.addAttribute("bodyStats", bodyStats);
        model.addAttribute("profileId", profileId);
        return "/bodystats/bodystats_new";
    }

    @PostMapping("/new")
    public String createNewBodyStats(@ModelAttribute BodyStats bodyStats, @RequestParam UUID profileId) {
        logger.info("Received profileId: {}", profileId);
        bodyStats.setProfileId(profileId);
        bodyStatsService.saveBodyStats(bodyStats);
        return "redirect:/bodystats/history?profileId=" + profileId;
    }
}
