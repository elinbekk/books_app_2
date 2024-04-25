package ru.itis.semester_work3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.semester_work3.dto.UserDto;
import ru.itis.semester_work3.entity.UserEntity;
import ru.itis.semester_work3.entity.enums.Role;
import ru.itis.semester_work3.entity.enums.State;
import ru.itis.semester_work3.repo.UserRepository;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adm")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    private final UserRepository userRepository;

    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin_page";
    }

    @GetMapping("{adm}")
    public String editUserPage(@PathVariable UserEntity adm, Model model) {
        model.addAttribute("user", adm);
        model.addAttribute("roles", Arrays.asList(Role.values()));
        return "edit_user_page";
    }

    @PostMapping
    public String userSaveByAdmin(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") UserEntity user,
            @RequestParam("state") String state
            ) {
        user.setUsername(username);

        if(state.equals("block")){
            user.setState(State.BLOCKED);
        }else{
            user.setState(State.ACTIVE);
        }
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);
        return "redirect:/adm";
    }
}
