package ru.itis.semester_work3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.security.UserDetailsImpl;
import ru.itis.semester_work3.services.impl.BookServiceImpl;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainPageController {
    private final BookServiceImpl bookService;
    @GetMapping("/main")
    public String showMainPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        List<BookDto> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("user", user);
        return "main_page";
    }
}
