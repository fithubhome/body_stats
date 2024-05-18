package ro.bodystats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.bodystats.model.BodyStats;
import ro.bodystats.service.BodyStatsService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/bodystats")
public class BodyStatsController {

    @Autowired
    private BodyStatsService bodyStatsService;

    // Define fixed UUIDs
    private static final List<UUID> PROFILE_IDS = Arrays.asList(
            UUID.fromString("11111111-1111-1111-1111-111111111111"),
            UUID.fromString("22222222-2222-2222-2222-222222222222"),
            UUID.fromString("33333333-3333-3333-3333-333333333333"),
            UUID.fromString("44444444-4444-4444-4444-444444444444"),
            UUID.fromString("55555555-5555-5555-5555-555555555555"),
            UUID.fromString("66666666-6666-6666-6666-666666666666"),
            UUID.fromString("77777777-7777-7777-7777-777777777777")
    );

    @GetMapping("")
    public String getBodyStatsForm(Model model) {
        model.addAttribute("profileIds", PROFILE_IDS);
        return "/bodystats/bodystats_form";
    }

    @PostMapping("")
    public String getLastBodyStats(@RequestParam UUID profileId, Model model) {
        BodyStats bodyStats = bodyStatsService.getLastBodyStats(profileId);
        model.addAttribute("bodyStats", bodyStats);
        model.addAttribute("selectedProfileId", profileId);
        return "/bodystats/bodystats";
    }

    @GetMapping("/history")
    public String getBodyStatsHistory(@RequestParam UUID profileId, Model model) {
        List<BodyStats> bodyStatsList = bodyStatsService.getBodyStatsByProfileId(profileId);
        model.addAttribute("bodyStatsList", bodyStatsList);
        model.addAttribute("selectedProfileId", profileId);
        return "/bodystats/bodystats_history";
    }

    @GetMapping("/{id}")
    public String getBodyStatsById(@PathVariable UUID id, @RequestParam UUID profileId, Model model) {
        Optional<BodyStats> bodyStats = bodyStatsService.getBodyStatsById(id);
        model.addAttribute("bodyStats", bodyStats.orElse(null));
        model.addAttribute("selectedProfileId", profileId); // Add profileId to the model
        return "/bodystats/bodystats_detail";
    }

    @GetMapping("/new")
    public String showNewBodyStatsForm(@RequestParam UUID profileId, Model model) {
        BodyStats bodyStats = new BodyStats();
        bodyStats.setProfileId(profileId);
        model.addAttribute("bodyStats", bodyStats);
        model.addAttribute("selectedProfileId", profileId);
        return "/bodystats/bodystats_new";
    }

    @PostMapping("/new")
    public String createNewBodyStats(@ModelAttribute BodyStats bodyStats, @RequestParam UUID profileId) {
        bodyStats.setProfileId(profileId);
        bodyStatsService.saveBodyStats(bodyStats);
        return "redirect:/bodystats/history?profileId=" + profileId;
    }
}
