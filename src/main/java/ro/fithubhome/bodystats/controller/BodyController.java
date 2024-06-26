package ro.fithubhome.bodystats.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.fithubhome.bodystats.exception.EntityAlreadyExistsException;
import ro.fithubhome.bodystats.exception.EntityNotFoundException;
import ro.fithubhome.bodystats.service.Logger;
import ro.fithubhome.bodystats.model.Body;
import ro.fithubhome.bodystats.service.BodyService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bodystats")
public class BodyController {
    @Autowired
    private BodyService bodyService;

    //POST Create
    @PostMapping()
    @Validated
/*
    private String handleBodyStats(@Valid Body bodyStatsDTO) {
        bodyService.createBodyStats(bodyStatsDTO);
        return "/bodystats/data.html";
    }
*/
    public ResponseEntity<Body> createBodyStats(@Valid @RequestBody Body body) {
        Logger.logInfo(String.format("%s - received POST request", this.getClass().getSimpleName()));

        try {
            Body createdBody = bodyService.createBodyStats(body);
            return ResponseEntity
                    .status(201)
                    .body(createdBody);
        } catch (EntityAlreadyExistsException ex) {
            Logger.logError(String.format("%s - POST request failed: \"%s\"", this.getClass().getSimpleName(), ex.getMessage()));
            return ResponseEntity
                    .status(409)
                    .body(null);
        }
    }

    //GET Request

    @GetMapping("/history")
    public String getBodyStatsHistory(Model model) {
        model.addAttribute("body", new Body());
        return "bodystats-history";
    }

/*    @GetMapping("/records")
        private ModelAndView getBodyStatsRecords() {
            ModelAndView modelAndView = new ModelAndView("templates/bodystats-records.html");
            modelAndView.addObject("bodyStatsRecords", bodyService.requestBodyStats(id));

            return modelAndView;
        }
*/
    @GetMapping("/{id}")
    public ResponseEntity<Body> requestedBodyStats(@PathVariable Integer id) {
        Logger.logInfo(String.format("%s - received GET request for city: \"%s\"", this.getClass().getSimpleName(), id));
       try {
           Body requestedBodyStats = bodyService.getBodyStatsById(id).orElseThrow(() -> new EntityNotFoundException("Body stats"));
           return ResponseEntity
                    .status(200)
                    .body(requestedBodyStats);
        } catch (EntityNotFoundException ex) {
           Logger.logError(String.format("%s - GET request failed for ID \"%s\": \"%s\"", this.getClass().getSimpleName(), id, ex.getMessage()));
           return ResponseEntity
                    .status(404)
                    .body(null);
        }
    /*   } catch (EntityNotFoundException ex) {
        Logger.logError(String.format("%s - GET request failed for city \"%s\": \"%s\"", this.getClass().getSimpleName(), id, ex.getMessage()));
        return ResponseEntity
                .status(404)
                .body(null);
    }*/
    }

    @GetMapping()
    public ResponseEntity<List<Body>> requestsBodyStats() {
        Logger.logInfo(String.format("%s - received GET request", this.getClass().getSimpleName()));
        List<Body> bodyStatsList = bodyService.getAllBodyStats();
        return ResponseEntity
                .status(200)
                .body(bodyStatsList);
    }

    //PUT
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

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Body> deleteBodyStats(@PathVariable Integer id) {
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

    @ExceptionHandler(Exception.class)
    private String handleException(Exception ex) {
        System.err.println("Exception in controller" + ex);
        return "error.html";
    }


}
