package ro.fithubhome.bodystats.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fithubhome.bodystats.exception.EntityAlreadyExistsException;
import ro.fithubhome.bodystats.exception.EntityNotFoundException;
import ro.fithubhome.bodystats.service.Logger;
import ro.fithubhome.bodystats.model.Body;
import ro.fithubhome.bodystats.service.BodyService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("")
public class BodyController {
    @Autowired
    private BodyService bodyService;

    @GetMapping("/record")
    public void createBodyStats(@RequestBody Body body) throws EntityAlreadyExistsException {
        Logger.logInfo(String.format("%s - received POST request", this.getClass().getSimpleName()));
        bodyService.createBodyStats(body);
    }

    @GetMapping()
    public ResponseEntity<Body> requestedBodyStats(@RequestBody UUID profileId) {
        Logger.logInfo(String.format("%s - received GET request for city: \"%s\"", this.getClass().getSimpleName(), profileId));
        try {
            Body requestedBodyStats = bodyService.getBodyStatsById(profileId).orElseThrow(() -> new EntityNotFoundException("Body stats"));
            return ResponseEntity
                    .status(200)
                    .body(requestedBodyStats);
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - GET request failed for ID \"%s\": \"%s\"", this.getClass().getSimpleName(), profileId, ex.getMessage()));
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<Body> updateBodyStatsForUser(@Valid @RequestBody Body body) throws EntityNotFoundException {
        Logger.logInfo(String.format("%s - received PUT request", this.getClass().getSimpleName()));
        try {
            Body updateBodyStats = bodyService.updateBodyStats(body);
            return ResponseEntity
                    .status(200)
                    .body(updateBodyStats);
        } catch(EntityNotFoundException ex) {
        Logger.logError(String.format("%s - PUT request failed: \"%s\"", this.getClass().getSimpleName(), ex.getMessage()));
        return ResponseEntity
                .status(404)
                .body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Body> deleteBodyStats(@PathVariable UUID id) {
        Logger.logInfo(String.format("%s - received DELETE request for city: \"%s\"", this.getClass().getSimpleName(), id));
    try {
        bodyService.deleteBodyStatsById(id);
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
