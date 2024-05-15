package ru.itis.semester_work3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.dto.FavouriteDto;
import ru.itis.semester_work3.security.UserDetailsImpl;
import ru.itis.semester_work3.services.impl.BookServiceImpl;
import ru.itis.semester_work3.services.impl.FavouriteServiceImpl;

import java.io.IOException;
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
