package com.logicminds.usedcar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(String username, String password, Model model) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        if(username.equals("admin") && password.equals("1234")) {
            return "redirect:/estimator";
        } else {
            model.addAttribute("error", "Username or Password is wrong");
            return "login";
        }
    }

    @GetMapping("/estimator")
    public String estimatorPage() {
        return "estimator";
    }
}
