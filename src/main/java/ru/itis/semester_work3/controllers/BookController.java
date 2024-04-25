package ru.itis.semester_work3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.entity.BookEntity;
import ru.itis.semester_work3.security.UserDetailsImpl;
import ru.itis.semester_work3.services.impl.BookServiceImpl;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookService;

    @GetMapping("/add_book")
    public String showAddBookPage(@AuthenticationPrincipal UserDetailsImpl user, Model model){
        model.addAttribute("user", user.getUserEntity());
        return "add_book_page";
    }

    @PostMapping("/add_book")
    public String addBook(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute("book") BookDto book, Model model){
        book.setOwnerId(user.getUserEntity().getUserId());
        bookService.saveBook(book);
        model.addAttribute("book", book);
        model.addAttribute("user", user.getUserEntity());
        model.addAttribute("message", "Книга \"" + book.getTitle() +"\" добавлена");
        return "add_book_page";
    }

    @GetMapping("/my_books")
    public String showMyBooksPage(@AuthenticationPrincipal UserDetailsImpl user, Model model){
        UUID userId = user.getUserEntity().getUserId();
        model.addAttribute("books", bookService.getBooksByUserId(userId));
        return "my_books_page";
    }

//    @PostMapping("/my_books")
//    public String deleteBook(@AuthenticationPrincipal UserDetailsImpl user, Model model){
//        UUID userId = user.getUserEntity().getUserId();
//        bookService.deleteBookById();
//    }
}
