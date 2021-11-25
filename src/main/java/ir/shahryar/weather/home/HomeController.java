package ir.shahryar.weather.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String showHomePage() {
        return "index";
    }
}
