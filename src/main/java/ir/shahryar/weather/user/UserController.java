package ir.shahryar.weather.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("login")
    public String showLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute(name = "user") User user, Model model) {
        User mainUser = service.findUserByUsername(user.getUsername());
        if (mainUser.getUsername() != null) {
            String token = service.getToken(mainUser);
            model.addAttribute("token", token);
            return showHome(model);
        } else {
            System.err.println("User name not found");
            return "login";
        }
    }

    @GetMapping("sign-up")
    public String showSignUp(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "sign-up";
    }

    @PostMapping("sign-up")
    public String signUp(@ModelAttribute(value = "user") User user, Model model) {
        user.setRequestRemains(10);
        service.save(user);
        return showHome(model);
    }

    @GetMapping("weather")
    public String showHome(Model model) {
        String city = "Tehran";
        model.addAttribute("city", city);
        return "home";
    }
}
