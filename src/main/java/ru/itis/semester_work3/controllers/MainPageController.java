package ru.itis.semester_work3.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.semester_work3.security.UserDetailsImpl;

@Controller
public class MainPageController {
    @GetMapping("/main")
    public String showMainPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", user);
        return "main_page";
    }
}
