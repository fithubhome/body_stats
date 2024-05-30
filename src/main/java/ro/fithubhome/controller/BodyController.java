package ro.fithubhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.fithubhome.exception.EntityAlreadyExistsException;
import ro.fithubhome.exception.EntityNotFoundException;
import ro.fithubhome.model.Body;
import ro.fithubhome.service.BodyService;
import ro.fithubhome.service.Logger;

import java.util.List;

@Controller
@RequestMapping("/bodystats")
public class BodyController {
    @Autowired
    private BodyService bodyService;

    //POST Create
    @PostMapping()
    ResponseEntity<Body> createBodyStats(@RequestBody Body body) {
        Logger.logInfo(String.format("%s - received POST request", this.getClass().getSimpleName()));

        Body createdWeather;
        try {
            createdWeather = bodyService.createBodyStats(body);
        } catch (EntityAlreadyExistsException ex) {
            Logger.logError(String.format("%s - POST request failed: \"%s\"", this.getClass().getSimpleName(), ex.getMessage()));
            return ResponseEntity
                    .status(409)
                    .body(null);
        }
        return ResponseEntity
                .status(201)
                .body(createdWeather);
    }

    //GET Request
    @GetMapping("/{profileID}")
    ResponseEntity<Body> requestedBodyStats(@PathVariable String profileID) {
        Logger.logInfo(String.format("%s - received GET request for city: \"%s\"", this.getClass().getSimpleName(), profileID));

        Body requestedBodyStats;
        try {
            requestedBodyStats = bodyService.requestBodyStats(profileID);
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - GET request failed for city \"%s\": \"%s\"", this.getClass().getSimpleName(), profileID, ex.getMessage()));
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
        return ResponseEntity
                .status(200)
                .body(requestedBodyStats);
    }
    @GetMapping()
    public ResponseEntity<List<Body>> requestsBodyStats() {
        Logger.logInfo(String.format("%s - received GET request", this.getClass().getSimpleName()));
        return ResponseEntity
                .status(200)
                .body(bodyService.requestsBodyStats());
    }
    @PutMapping()
    ResponseEntity<Body> updateBodyStatsForUser(@RequestBody Body body) {
        Logger.logInfo(String.format("%s - received PUT request", this.getClass().getSimpleName()));

        Body updateBodyStats;
        try {
            updateBodyStats = bodyService.updateBodyStats(body);
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - PUT request failed: \"%s\"", this.getClass().getSimpleName(), ex.getMessage()));
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
        return ResponseEntity
                .status(200)
                .body(updateBodyStats);
    }

    //DELETE
    @DeleteMapping("/{profileId}")
    ResponseEntity<Body> deleteBodyStats(@PathVariable String profileId) {
        Logger.logInfo(String.format("%s - received DELETE request for city: \"%s\"", this.getClass().getSimpleName(), profileId));

        Body deletedBodyStats;
        try {
            deletedBodyStats = bodyService.deleteBodyStats(profileId);
        } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - DELETE request failed for city \"%s\": \"%s\"", this.getClass().getSimpleName(), profileId, ex.getMessage()));
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
        return ResponseEntity
                .status(200)
                .body(deletedBodyStats);
    }

}
