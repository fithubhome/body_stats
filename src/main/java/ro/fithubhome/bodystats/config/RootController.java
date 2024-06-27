package ro.fithubhome.bodystats.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController implements ErrorController {
    @RequestMapping("error")
    private String handleError() {
        return "error/error.html";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
