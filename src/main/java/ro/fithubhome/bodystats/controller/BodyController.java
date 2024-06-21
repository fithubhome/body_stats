package ro.fithubhome.bodystats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private Body body;
    //POST Create
    @PostMapping()
    /*@Validated
    private String handleBodyStats(@Valid Body bodyStatsDTO) {
        bodyService.createBodyStats(bodyStatsDTO);
        return "/bodystats/data.html";
    }
    */
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

    @GetMapping("/history")
    public String getBodyStatsHistory(Model model)  {
        model.addAttribute("body", body);
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
   ResponseEntity<Optional<Body>> requestedBodyStats(@PathVariable String id) {
        Logger.logInfo(String.format("%s - received GET request for city: \"%s\"", this.getClass().getSimpleName(), id));

        Optional<Body> requestedBodyStats;

       requestedBodyStats = bodyService.getBodyStatsById(Integer.valueOf(id));
       /*   } catch (EntityNotFoundException ex) {
        Logger.logError(String.format("%s - GET request failed for city \"%s\": \"%s\"", this.getClass().getSimpleName(), id, ex.getMessage()));
        return ResponseEntity
                .status(404)
                .body(null);
    }*/
       return ResponseEntity
                .status(200)
                .body(requestedBodyStats);

    }
    @GetMapping()
    public ResponseEntity<List<Body>> requestsBodyStats() {
        Logger.logInfo(String.format("%s - received GET request", this.getClass().getSimpleName()));
        return ResponseEntity
                .status(200)
                .body(bodyService.getAllBodyStats());
    }
    //PUT
    @PutMapping()
    ResponseEntity<Body> updateBodyStatsForUser(@RequestBody Body body) {
        Logger.logInfo(String.format("%s - received PUT request", this.getClass().getSimpleName()));

        Body updateBodyStats;
        //try {
            updateBodyStats = bodyService.updateBodyStats(body);
        //}
        /*catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - PUT request failed: \"%s\"", this.getClass().getSimpleName(), ex.getMessage()));
            return ResponseEntity
                    .status(404)
                    .body(null);
        }*/
        return ResponseEntity
                .status(200)
                .body(updateBodyStats);
    }

    //DELETE
    @DeleteMapping("/{id}")
    ResponseEntity<Body> deleteBodyStats(@PathVariable String id) {
        Logger.logInfo(String.format("%s - received DELETE request for city: \"%s\"", this.getClass().getSimpleName(), id));

        Body deletedBodyStats;
    //    try {
            deletedBodyStats = bodyService.deleteBodyStatsById(Integer.valueOf(id));
    /*    } catch (EntityNotFoundException ex) {
            Logger.logError(String.format("%s - DELETE request failed for city \"%s\": \"%s\"", this.getClass().getSimpleName(), id, ex.getMessage()));
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
    */    return ResponseEntity
                .status(200)
                .body(deletedBodyStats);
    }

    @ExceptionHandler(Exception.class)
    private String handleException(Exception ex) {
        System.err.println("Exception in \"ProfileID\" controller" +ex);
        return "error.html";
    }


}
