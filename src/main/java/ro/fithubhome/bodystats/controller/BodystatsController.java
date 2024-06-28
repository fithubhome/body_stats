package ro.fithubhome.bodystats.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fithubhome.bodystats.exception.EntityNotFoundException;
import ro.fithubhome.bodystats.model.Bodystats;
import ro.fithubhome.bodystats.service.Logger;
import ro.fithubhome.bodystats.service.BodystatsService;
import java.util.UUID;

@RestController
@RequestMapping("")
public class BodystatsController {
    @Autowired
    private BodystatsService bodystatsService;

    @GetMapping("/record")
    public void createBodyStats(@RequestBody Bodystats bodystats) {
        Logger.logInfo(String.format("%s - received POST request", this.getClass().getSimpleName()));
        bodystatsService.createBodyStats(bodystats);
    }

    @GetMapping()
    public ResponseEntity<Bodystats> requestedBodyStats(@RequestBody UUID profileId) {
        Logger.logInfo(String.format("%s - received GET request for city: \"%s\"", this.getClass().getSimpleName(), profileId));
        try {
            Bodystats requestedBodystatsStats = bodystatsService.getBodyStatsById(profileId).orElseThrow(() -> new EntityNotFoundException("Bodystats stats"));
            return ResponseEntity
                    .status(200)
                    .body(requestedBodystatsStats);
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - GET request failed for ID \"%s\": \"%s\"", this.getClass().getSimpleName(), profileId, ex.getMessage()));
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<Bodystats> updateBodyStatsForUser(@Valid @RequestBody Bodystats bodystats) {
        Logger.logInfo(String.format("%s - received PUT request", this.getClass().getSimpleName()));
        try {
            Bodystats updateBodystatsStats = bodystatsService.updateBodyStats(bodystats);
            return ResponseEntity
                    .status(200)
                    .body(updateBodystatsStats);
        } catch(EntityNotFoundException ex) {
        Logger.logError(String.format("%s - PUT request failed: \"%s\"", this.getClass().getSimpleName(), ex.getMessage()));
        return ResponseEntity
                .status(404)
                .body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bodystats> deleteBodyStats(@PathVariable UUID id) {
        Logger.logInfo(String.format("%s - received DELETE request for city: \"%s\"", this.getClass().getSimpleName(), id));
    try {
        bodystatsService.deleteBodyStatsById(id);
        return ResponseEntity
                .status(204)
                .body(null);
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - DELETE request failed for city \"%s\": \"%s\"", this.getClass().getSimpleName(), id, ex.getMessage()));
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
    }

}
