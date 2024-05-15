package ru.itis.semester_work3.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import netscape.javascript.JSObject;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.security.UserDetailsImpl;
import ru.itis.semester_work3.services.impl.BookServiceImpl;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainPageController {
    private final BookServiceImpl bookService;

    @GetMapping("/main")
    public String showMainPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        List<BookDto> books;
        books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("user", user);
        return "main_page";
    }


    @PostMapping("/main-search")
    @ResponseBody
    public List<BookDto> searchBooks(@RequestParam(required = false) String query, Model model) throws IOException {
        List<BookDto> books;
        System.err.println("QUERY: " + query);
        if (query != null && !query.isEmpty()) {
            books = bookService.getBookByTitleContaining(query);
        } else {
            books = bookService.getAllBooks();
        }
        return books;
    }
}
