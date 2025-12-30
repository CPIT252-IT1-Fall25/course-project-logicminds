package com.logicminds.usedcar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(String username, String password, Model model) {
        if ("admin".equals(username) && "1234".equals(password)) {
            return "redirect:/car-form";
        } else {
            model.addAttribute("error", "Username or password is incorrect.");
            return "login";
        }
    }
}
