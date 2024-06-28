package ro.fithubhome.bodystats.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fithubhome.bodystats.exception.EntityNotFoundException;
import ro.fithubhome.bodystats.model.BodyStats;
import ro.fithubhome.bodystats.service.Logger;
import ro.fithubhome.bodystats.service.BodyStatsService;
import java.util.UUID;

@RestController
@RequestMapping("/bodystats")
public class BodyStatsController {
    @Autowired
    private BodyStatsService bodystatsService;

    @PostMapping("/record")
    public ResponseEntity<BodyStats> createBodyStats(@Valid @RequestBody BodyStats bodystats) {
        Logger.logInfo(String.format("%s - received POST request", this.getClass().getSimpleName()));
        bodystatsService.createBodyStats(bodystats);
        return ResponseEntity.status(201).body(bodystats);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<BodyStats> getBodyStatsByProfileId(@PathVariable UUID profileId) {
        Logger.logInfo(String.format("%s - received GET request for profileId: \"%s\"", this.getClass().getSimpleName(), profileId));
        try {
            BodyStats requestedBodyStatsStats = bodystatsService.getBodyStatsById(profileId).orElseThrow(() -> new EntityNotFoundException("BodyStats stats"));
            return ResponseEntity.status(200).body(requestedBodyStatsStats);
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - GET request failed for ID \"%s\": \"%s\"", this.getClass().getSimpleName(), profileId, ex.getMessage()));
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<BodyStats> updateBodyStats(@Valid @RequestBody BodyStats bodystats) {
        Logger.logInfo(String.format("%s - received PUT request", this.getClass().getSimpleName()));
        try {
            BodyStats updateBodyStatsStats = bodystatsService.updateBodyStats(bodystats);
            return ResponseEntity.status(200).body(updateBodyStatsStats);
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - PUT request failed: \"%s\"", this.getClass().getSimpleName(), ex.getMessage()));
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBodyStats(@PathVariable UUID id) {
        Logger.logInfo(String.format("%s - received DELETE request for id: \"%s\"", this.getClass().getSimpleName(), id));
        try {
            bodystatsService.deleteBodyStatsById(id);
            return ResponseEntity.status(204).build();
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - DELETE request failed for id \"%s\": \"%s\"", this.getClass().getSimpleName(), id, ex.getMessage()));
            return ResponseEntity.status(404).build();
        }
    }
}
