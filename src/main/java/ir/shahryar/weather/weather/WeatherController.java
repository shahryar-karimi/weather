package ir.shahryar.weather.weather;

import ir.shahryar.weather.weather.status.WeatherStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {

    @Autowired
    WeatherService service;

    @PostMapping("weather/call")
    public String showOverView(@ModelAttribute(name = "city") String city, @ModelAttribute(name = "days") int days, Model model) {
        WeatherStatus status = service.getStatus(city, days);
        model.addAttribute(status);
        return "weather-status";
    }
}
