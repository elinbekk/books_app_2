package ru.itis.semester_work3.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semester_work3.dto.UserDto;
import ru.itis.semester_work3.services.UserService;

@Controller
@RequiredArgsConstructor
public class SignUpController {
    private final UserService userService;

    @GetMapping("/sign-up")
    private String showSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/sign-up")
    public String registrateUser(UserDto user, Model model) {
        if(userService.isUserExists(user.getUsername())){
            model.addAttribute("message", "User with this email already exists");
            return "sign_up_page";
        }
        userService.registerUser(user);
        return "redirect:/auth";
    }

    @GetMapping("/auth-error")
    public String authError(Model model) {
        model.addAttribute("message", "Incorrect username or password");
        return "auth_page";
    }

}
